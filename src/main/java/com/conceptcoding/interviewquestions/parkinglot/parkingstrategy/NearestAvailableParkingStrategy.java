package com.conceptcoding.interviewquestions.parkinglot.parkingstrategy;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpot;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpotManager;

public class NearestAvailableParkingStrategy implements ParkingStrategy {
    private ParkingSpotManager spotManager;

    public NearestAvailableParkingStrategy(ParkingSpotManager spotManager) {
        this.spotManager = spotManager;
    }

    @Override
    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        return spotManager.findNearestAvailableSpot(vehicleType);
    }

    @Override
    public void releaseSpot(ParkingSpot spot) {
        spotManager.unParkVehicle(spot);
    }
}
