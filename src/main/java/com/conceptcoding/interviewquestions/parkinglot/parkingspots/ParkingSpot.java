package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

public abstract class ParkingSpot {
    private String spotId;
    private boolean isAvailable;
    private Vehicle vehicle;
    private double price;

    ParkingSpot() {

    }

    public ParkingSpot(String id, double price) {
        this.spotId = id;
        this.isAvailable = true;
        this.price = price;
    }

    public abstract void assignVehicleToParkingSpot(Vehicle vehicle);

    public abstract boolean checkIfVehicleFits(VehicleType vehicleType);

    // getters and setters
    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        if (!isAvailable && vehicle != null) {
            System.out.println("[+] Parking Spot " + spotId + " freed.");
            vehicle = null;
            isAvailable = true;
        }
    }
}