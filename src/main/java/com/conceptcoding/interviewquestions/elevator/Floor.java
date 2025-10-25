package com.conceptcoding.interviewquestions.elevator;

import com.conceptcoding.interviewquestions.elevator.enums.ElevatorDirection;

public class Floor {

    int floorNumber;
    ExternalButton externalButton;
    Display display;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        externalButton = new ExternalButton();
    }

    public void pressButton(ElevatorDirection elevatorDirection) {
        externalButton.pressButton(floorNumber, elevatorDirection);
    }

    public void showDisplay() {
        display.showDisplay();
    }
}