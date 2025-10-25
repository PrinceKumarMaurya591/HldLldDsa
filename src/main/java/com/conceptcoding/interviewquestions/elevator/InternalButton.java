package com.conceptcoding.interviewquestions.elevator;


public class InternalButton {

    InternalDispatcher dispatcher = new InternalDispatcher();

    int[] floors = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int floorSelected;

    void pressButton(int destination, ElevatorCar elevatorCar) {

        // 1. Check if destination is in the list of available floors

        // 2. Submit the request to the jobDispatcher
        dispatcher.submitInternalRequest(destination, elevatorCar);
    }

}
