package com.conceptcoding.interviewquestions.parkinglot.gates;

import com.conceptcoding.interviewquestions.parkinglot.parkingspots.NullSpot;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpot;
import com.conceptcoding.interviewquestions.parkinglot.parkingstrategy.ParkingStrategy;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

public class EntryGate {
    private ParkingStrategy parkingStrategy;
    private int ticketCounter;

    public EntryGate(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        this.ticketCounter = 0;
    }

    public Ticket issueTicket(Vehicle vehicle) {
        ParkingSpot spot = parkingStrategy.findAvailableSpot(vehicle.getVehicleType());

        if (spot instanceof NullSpot) {
            System.out.println("[-] No available parking spot for vehicle: " + vehicle.getVehicleNo());
            System.exit(0);
        }
        spot.assignVehicleToParkingSpot(vehicle);
        ticketCounter++;
        Ticket ticket = new Ticket(spot, vehicle);

        System.out.println("[+] Parking Ticket Issued: " + ticket.getTicketNo()
                + " for Vehicle " + vehicle.getVehicleNo() + " at Spot: " + spot.getSpotId());

        return ticket;
    }

}
