package com.conceptcoding.interviewquestions.parking_lot;

import com.conceptcoding.interviewquestions.parking_lot.ParkingSpot.ParkingSpot;
import com.conceptcoding.interviewquestions.parking_lot.ParkingSpot.ParkingSpotManager;

public class ParkingLevel {

    private final int levelNumber;
    private final ParkingSpotManager twoWheelerManager;
    private final ParkingSpotManager fourWheelerManager;

    public ParkingLevel(int levelNumber,
                        ParkingSpotManager twoWheelerManager,
                        ParkingSpotManager fourWheelerManager) {
        this.levelNumber = levelNumber;
        this.twoWheelerManager = twoWheelerManager;
        this.fourWheelerManager = fourWheelerManager;
    }

    public boolean hasAvailability(VehicleType type) {
        return getManager(type).hasFreeSpot();
    }

    public ParkingSpot park(VehicleType type) {
        return getManager(type).park();
    }

    public void unPark(VehicleType type, ParkingSpot spot) {
        getManager(type).unPark(spot);
    }

    private ParkingSpotManager getManager(VehicleType type) {
        return switch (type) {
            case TWO_WHEELER -> twoWheelerManager;
            case FOUR_WHEELER -> fourWheelerManager;
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
