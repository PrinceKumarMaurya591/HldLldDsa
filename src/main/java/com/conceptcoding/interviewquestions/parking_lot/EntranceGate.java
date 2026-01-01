package com.conceptcoding.interviewquestions.parking_lot;

public class EntranceGate {

    private final ParkingLot parkingLot;

    public EntranceGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket enter(Vehicle vehicle) {
        return parkingLot.allocate(vehicle);
    }
}
