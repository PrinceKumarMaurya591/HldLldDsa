package com.conceptcoding.interviewquestions.elevator;

import com.conceptcoding.interviewquestions.elevator.enums.ElevatorDirection;

public class ExternalButton {

    ElevatorDirection directionRequest;
    ExternalDispatcher externalDispatcher;

    public ExternalButton() {
        externalDispatcher = new ExternalDispatcher();
    }

    public void pressButton(int floor, ElevatorDirection elevatorDirection) {
        directionRequest = elevatorDirection;
        externalDispatcher.submitExternalRequest(floor, elevatorDirection);
    }
}
