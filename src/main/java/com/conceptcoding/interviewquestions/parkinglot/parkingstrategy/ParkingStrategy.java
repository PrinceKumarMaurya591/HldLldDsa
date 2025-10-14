package com.conceptcoding.interviewquestions.parkinglot.parkingstrategy;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpot;

public interface ParkingStrategy {
    abstract ParkingSpot findAvailableSpot(VehicleType vehicleType);

    abstract void releaseSpot(ParkingSpot spot);
}
