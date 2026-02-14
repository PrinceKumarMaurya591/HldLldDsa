package com.conceptcoding.interviewquestions.parking_lot_v2;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

// Enums
enum VehicleType {
    BIKE, CAR, VAN, TRUCK
}

enum PaymentMethod {
    CASH, CARD, UPI
}

// Vehicle
class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() { return licensePlate; }
    public VehicleType getType() { return type; }
}

// Parking Spot
class ParkingSpot {
    private final int id;
    private final int level;
    private final VehicleType supportedType;
    private boolean occupied = false;
    private Vehicle currentVehicle;

    public ParkingSpot(int id, int level, VehicleType supportedType) {
        this.id = id;
        this.level = level;
        this.supportedType = supportedType;
    }

    public synchronized boolean park(Vehicle vehicle) {
        if (!occupied && supportedType == vehicle.getType()) {
            currentVehicle = vehicle;
            occupied = true;
            return true;
        }
        return false;
    }

    public synchronized void unpark() {
        currentVehicle = null;
        occupied = false;
    }

    public boolean isOccupied() { return occupied; }
    public int getId() { return id; }
    public int getLevel() { return level; }
    public VehicleType getSupportedType() { return supportedType; }
}

// Parking Level
class ParkingLevel {
    private final int levelNumber;
    private final List<ParkingSpot> spots;

    public ParkingLevel(int levelNumber, List<ParkingSpot> spots) {
        this.levelNumber = levelNumber;
        this.spots = spots;
    }

    public int getLevelNumber() { return levelNumber; }
    public List<ParkingSpot> getSpots() { return spots; }
}

// Strategy Interfaces
interface ParkingStrategy {
    ParkingSpot findSpot(ParkingLot lot, VehicleType type);
}

interface PricingStrategy {
    double calculateFee(Date entryTime, Date exitTime);
}

// Concrete Strategies
class RandomAvailableStrategy implements ParkingStrategy {
    private final Random random = new Random();

    @Override
    public ParkingSpot findSpot(ParkingLot lot, VehicleType type) {
        List<ParkingSpot> candidates = new ArrayList<>();
        for (ParkingLevel level : lot.getLevels()) {
            for (ParkingSpot spot : level.getSpots()) {
                if (!spot.isOccupied() && spot.getSupportedType() == type) {
                    candidates.add(spot);
                }
            }
        }
        if (candidates.isEmpty()) return null;
        return candidates.get(random.nextInt(candidates.size()));
    }
}

class NearestLevelStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(ParkingLot lot, VehicleType type) {
        for (ParkingLevel level : lot.getLevels()) {  // from ground up
            for (ParkingSpot spot : level.getSpots()) {
                if (!spot.isOccupied() && spot.getSupportedType() == type) {
                    return spot;
                }
            }
        }
        return null;
    }
}

class HourlyPricingStrategy implements PricingStrategy {
    private final double ratePerHour;

    public HourlyPricingStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateFee(Date entryTime, Date exitTime) {
        long millis = exitTime.getTime() - entryTime.getTime();
        double hours = millis / (1000.0 * 60 * 60);
        return Math.ceil(hours) * ratePerHour;
    }
}

class FlatRatePricingStrategy implements PricingStrategy {
    private final double flatRate;

    public FlatRatePricingStrategy(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculateFee(Date entryTime, Date exitTime) {
        return flatRate;
    }
}

// Ticket
class Ticket {
    private final String id = UUID.randomUUID().toString();
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final int levelNumber;
    private final Date entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot spot, int levelNumber) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.levelNumber = levelNumber;
        this.entryTime = new Date();
    }

    public String getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public int getLevelNumber() { return levelNumber; }
    public Date getEntryTime() { return entryTime; }
}

// Payment
class Payment {
    private final double amount;
    private final PaymentMethod method;

    public Payment(double amount, PaymentMethod method) {
        this.amount = amount;
        this.method = method;
    }

    public boolean process() {
        // Simulate payment gateway
        System.out.println("Payment of $" + amount + " via " + method + " → SUCCESS");
        return true;
    }
}

// Parking Lot (main coordinator)
class ParkingLot {
    public final List<ParkingLevel> levels;
    public final List<EntryGate> entryGates;
    public final List<ExitGate> exitGates;
    public final ParkingStrategy parkingStrategy;
    public final PricingStrategy pricingStrategy;
    public final ReentrantLock lock = new ReentrantLock();

    public ParkingLot(int numLevels, int spotsPerLevel, ParkingStrategy parkingStrategy, PricingStrategy pricingStrategy) {
        this.levels = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.parkingStrategy = parkingStrategy;
        this.pricingStrategy = pricingStrategy;

        for (int i = 1; i <= numLevels; i++) {
            List<ParkingSpot> spots = new ArrayList<>();
            for (int j = 1; j <= spotsPerLevel; j++) {
                VehicleType type = (j <= spotsPerLevel / 4) ? VehicleType.BIKE :
                        (j <= spotsPerLevel / 2) ? VehicleType.CAR :
                                VehicleType.VAN;
                spots.add(new ParkingSpot(j, i, type));
            }
            levels.add(new ParkingLevel(i, spots));
        }

        for (int i = 1; i <= 3; i++) {
            entryGates.add(new EntryGate(i, this));
            exitGates.add(new ExitGate(i, this));
        }
    }

    public List<ParkingLevel> getLevels() { return levels; }

    public Ticket enterVehicle(Vehicle vehicle) {
        lock.lock();
        try {
            ParkingSpot spot = parkingStrategy.findSpot(this, vehicle.getType());
            if (spot == null) {
                System.out.println("No spot available for " + vehicle.getType());
                return null;
            }

            if (spot.park(vehicle)) {
                Ticket ticket = new Ticket(vehicle, spot, spot.getLevel());
                System.out.println("Vehicle " + vehicle.getLicensePlate() +
                        " parked at Level " + ticket.getLevelNumber() +
                        ", Spot " + spot.getId() + " | Ticket: " + ticket.getId());
                return ticket;
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    public double calculateFee(Ticket ticket) {
        return pricingStrategy.calculateFee(ticket.getEntryTime(), new Date());
    }

    public boolean exitVehicle(Ticket ticket, Payment payment) {
        lock.lock();
        try {
            double fee = calculateFee(ticket);
            if (payment.process()) {
                ticket.getSpot().unpark();
                System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() +
                        " exited. Fee: $" + fee + " | Spot freed.");
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}

// Entry Gate
class EntryGate {
    private final int id;
    private final ParkingLot parkingLot;

    public EntryGate(int id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public Ticket enter(Vehicle vehicle) {
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " at Entry Gate " + id);
        return parkingLot.enterVehicle(vehicle);
    }
}

// Exit Gate
class ExitGate {
    private final int id;
    private final ParkingLot parkingLot;

    public ExitGate(int id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    public boolean exit(Ticket ticket, Payment payment) {
        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " at Exit Gate " + id);
        return parkingLot.exitVehicle(ticket, payment);
    }
}

// ────────────────────────────────────────────────
//                  Demo / Main
// ────────────────────────────────────────────────
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingStrategy strategy = new RandomAvailableStrategy();
        // ParkingStrategy strategy = new NearestLevelStrategy();

        PricingStrategy pricing = new HourlyPricingStrategy(25.0);
        // PricingStrategy pricing = new FlatRatePricingStrategy(120.0);

        ParkingLot lot = new ParkingLot(4, 20, strategy, pricing);

        Vehicle car1 = new Vehicle("KA-01-AB-1234", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("MH-12-CD-5678", VehicleType.BIKE);

        EntryGate gate1 = lot.entryGates.get(0);
        Ticket ticket1 = gate1.enter(car1);
        Ticket ticket2 = gate1.enter(bike1);

        if (ticket1 != null) {
            Thread.sleep(3000); // simulate parking time
            ExitGate exit = lot.exitGates.get(0);
            Payment payment = new Payment(lot.calculateFee(ticket1), PaymentMethod.UPI);
            exit.exit(ticket1, payment);
        }
    }
}