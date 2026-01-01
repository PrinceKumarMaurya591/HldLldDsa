package com.conceptcoding.interviewquestions.parking_lot.ParkingSpot;

public class ParkingSpot {

    private final String spotId;
    private boolean free = true;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
    }

    boolean isSpotFree() {
        return free;
    }

    void occupySpot() {
        free = false;
    }

    void releaseSpot() {
        free = true;
    }

    public String getSpotId() {
        return spotId;
    }
}
