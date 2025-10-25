package com.conceptcoding.interviewquestions.elevator;

import com.conceptcoding.interviewquestions.elevator.enums.ElevatorDirection;
import com.conceptcoding.interviewquestions.elevator.enums.ElevatorState;

public class ElevatorCar {

    int id;
    Display display;
    InternalButton internalButton;
    ElevatorState elevatorState;
    int currentFloor;
    ElevatorDirection elevatorDirection;
    Door door;

    public ElevatorCar() {
        display = new Display();
        internalButton = new InternalButton();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        elevatorDirection = ElevatorDirection.UP;
        door = new Door();

    }

    public void showDisplay() {
        display.showDisplay();
    }

    public void pressButton(int destination) {
        internalButton.pressButton(destination, this);
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, elevatorDirection);
    }

    boolean moveElevator(ElevatorDirection dir, int destinationFloor) {
        int startFloor = currentFloor;
        if (dir == ElevatorDirection.UP) {
            for (int i = startFloor; i <= destinationFloor; i++) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;
                }
            }
        }

        if (dir == ElevatorDirection.DOWN) {
            for (int i = startFloor; i >= destinationFloor; i--) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;
    }

}
