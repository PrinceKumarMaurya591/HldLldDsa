package com.conceptcoding.interviewquestions.parking_lot;

import com.conceptcoding.interviewquestions.parking_lot.ParkingSpot.*;

import java.util.List;

public class ParkingLotClient {

    public static void main(String[] args) {

        ParkingSpotLookupStrategy strategy = new RandomLookupStrategy();

        ParkingLevel level1 = new ParkingLevel(
                1,
                new TwoWheelerSpotManager(
                        List.of(new ParkingSpot("L1-S1"),
                                new ParkingSpot("L1-S2")),
                        strategy),
                new FourWheelerSpotManager(
                        List.of(new ParkingSpot("L1-S3")),
                        strategy)
        );

        ParkingLevel level2 = new ParkingLevel(
                2,
                new TwoWheelerSpotManager(
                        List.of(new ParkingSpot("L2-S1")),
                        strategy),
                new FourWheelerSpotManager(
                        List.of(new ParkingSpot("L2-S2"),
                                new ParkingSpot("L2-S3")),
                        strategy)
        );

        ParkingLot parkingLot =
                new ParkingLot(
                        List.of(level1, level2),
                        new CostComputation(new HourlyPricingStrategy())
                );

        Vehicle bike = new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("CAR-201", VehicleType.FOUR_WHEELER);

        Ticket t1 = parkingLot.getEntranceGate().enter(bike);
        Ticket t2 = parkingLot.getEntranceGate().enter(car);

        parkingLot.getExitGate().exit(t1);
        parkingLot.getExitGate().exit(t2);
    }
}
