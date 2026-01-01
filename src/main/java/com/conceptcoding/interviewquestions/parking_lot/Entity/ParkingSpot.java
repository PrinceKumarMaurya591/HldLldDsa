package com.conceptcoding.interviewquestions.parking_lot.Entity;

public class ParkingSpot {

    private final String spotId;
    private boolean isFree = true;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
    }

    boolean isSpotFree() {
        return isFree;
    }

    void occupySpot() {
        isFree = false;
    }

    void releaseSpot() {
        isFree = true;
    }

    public String getSpotId() {
        return spotId;
    }
}
