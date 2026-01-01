package com.conceptcoding.interviewquestions.parking_lot.parkinglot;

import com.conceptcoding.interviewquestions.parking_lot.Entity.Vehicle;
import com.conceptcoding.interviewquestions.parking_lot.Ticket;

class ParkingLot {

    private final ParkingBuilding building;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding building,
                      EntranceGate entranceGate,
                      ExitGate exitGate) {
        this.building = building;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle) {
        return entranceGate.enter(building, vehicle);
    }

    public void vehicleExits(Ticket ticket) {
        exitGate.exit(building, ticket);
    }
}
