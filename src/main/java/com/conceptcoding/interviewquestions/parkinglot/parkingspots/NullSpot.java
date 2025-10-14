package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

public class NullSpot extends ParkingSpot {

    NullSpot() {
        super("0", 0);
    }

    @Override
    public void assignVehicleToParkingSpot(Vehicle vehicle) {
        System.out.println("[-] NullSpot: Vehicle cannot be assigned to this spot.");
    }

    @Override
    public boolean checkIfVehicleFits(VehicleType vehicleType) {
        return false;
    }
}
