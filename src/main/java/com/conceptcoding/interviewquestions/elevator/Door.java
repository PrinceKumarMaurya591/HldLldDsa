package com.conceptcoding.interviewquestions.elevator;

import com.conceptcoding.interviewquestions.elevator.enums.DoorState;

public class Door {
    DoorState doorState;

    public void openDoor() {
        doorState = DoorState.DOOR_OPEN;
        System.out.println("Opening the Elevator door ");
    }

    public void closeDoor() {
        doorState = DoorState.DOOR_CLOSED;
        System.out.println("Closing the Elevator door");
    }

}
