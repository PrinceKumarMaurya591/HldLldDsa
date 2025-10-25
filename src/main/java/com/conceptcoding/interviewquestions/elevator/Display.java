package com.conceptcoding.interviewquestions.elevator;

import com.conceptcoding.interviewquestions.elevator.enums.ElevatorDirection;

public class Display {

    int floor;
    ElevatorDirection elevatorDirection;

    public void setDisplay(int floor, ElevatorDirection elevatorDirection) {
        this.floor = floor;
        this.elevatorDirection = elevatorDirection;
    }

    public void showDisplay() {
        System.out.println(floor);
        System.out.println(elevatorDirection);
    }
}
