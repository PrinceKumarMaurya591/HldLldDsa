package com.conceptcoding.interviewquestions.parking_lot;

import com.conceptcoding.interviewquestions.parking_lot.ParkingSpot.ParkingSpot;

import java.util.List;

class ParkingLot {

    private final List<ParkingLevel> levels;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    public ParkingLot(List<ParkingLevel> levels,
                      CostComputation costComputation) {
        this.levels = levels;
        this.entranceGate = new EntranceGate(this);
        this.exitGate = new ExitGate(this, costComputation);
    }

    Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.hasAvailability(vehicle.getVehicleType())) {
                ParkingSpot spot = level.park(vehicle.getVehicleType());
                if (spot != null) {
                    return new Ticket(vehicle, level, spot);
                }
            }
        }
        throw new RuntimeException("Parking Full");
    }

    void release(Ticket ticket) {
        ticket.getLevel().unPark(
                ticket.getVehicle().getVehicleType(),
                ticket.getSpot()
        );
    }

    public EntranceGate getEntranceGate() {
        return entranceGate;
    }

    public ExitGate getExitGate() {
        return exitGate;
    }
}
