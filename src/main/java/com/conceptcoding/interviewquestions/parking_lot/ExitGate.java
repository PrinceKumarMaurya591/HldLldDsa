package com.conceptcoding.interviewquestions.parking_lot;

public class ExitGate {

    private final ParkingLot parkingLot;
    private final CostComputation costComputation;

    public ExitGate(ParkingLot parkingLot,
                    CostComputation costComputation) {
        this.parkingLot = parkingLot;
        this.costComputation = costComputation;
    }

    public void exit(Ticket ticket) {
        double amount = costComputation.compute(ticket);
        System.out.println("Payment done: " + amount);

        parkingLot.release(ticket);
    }
}
