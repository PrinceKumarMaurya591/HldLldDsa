package com.conceptcoding.interviewquestions.elevator;

import com.conceptcoding.interviewquestions.elevator.enums.ElevatorDirection;

import java.util.List;

public class ExternalDispatcher {

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, ElevatorDirection elevatorDirection) {

        // For simplicity, i am following even odd logic to assign the elevator to the floor
        for (ElevatorController elevatorController : elevatorControllerList) {

            int elevatorID = elevatorController.elevatorCar.id;
            if (elevatorID % 2 == 1 && floor % 2 == 1) {
                elevatorController.submitExternalRequest(floor, elevatorDirection);
            } else if (elevatorID % 2 == 0 && floor % 2 == 0) {
                elevatorController.submitExternalRequest(floor, elevatorDirection);

            }
        }
    }

}
