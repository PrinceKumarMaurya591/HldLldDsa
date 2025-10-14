package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotManager {
    private static ParkingSpotManager instance;
    private Map<String, ParkingSpot> parkingSpots;
    private Map<String, Ticket> tickets;

    private ParkingSpotManager() {
        this.parkingSpots = new HashMap<>();
    }

    public static synchronized ParkingSpotManager getInstance() {
        if (instance == null) {
            instance = new ParkingSpotManager();
        }
        return instance;
    }

    public void unParkVehicle(ParkingSpot spot) {
        spot.removeVehicle();
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getSpotId(), spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpots.remove(spot.getSpotId());
    }

    public ParkingSpot findFirstAvailableSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.isAvailable() && spot.checkIfVehicleFits(vehicleType)) {
                return spot;
            }
        }
        return new NullSpot();
    }

    public ParkingSpot findNearestAvailableSpot(VehicleType vehicleType) {
        // min Heap implementation of parkingSpots
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.isAvailable() && spot.checkIfVehicleFits(vehicleType)) {
                return spot;
            }
        }
        return new NullSpot();
    }

    public int getAvailableSpotsCount() {
        return (int) parkingSpots.values().stream()
                .filter(ParkingSpot::isAvailable)
                .count();
    }
}
