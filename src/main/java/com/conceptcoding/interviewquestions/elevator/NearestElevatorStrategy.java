package com.conceptcoding.interviewquestions.elevator;

import com.conceptcoding.interviewquestions.elevator.enums.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {

    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers,
                                             int requestFloor,
                                             ElevatorDirection direction) {

        ElevatorController best = null;
        int minDistance = Integer.MAX_VALUE;

        //1. Pick the one which is going in same direction and minimum distance from the destination
        for (ElevatorController controller : controllers) {
            int currentFloor = controller.elevatorCar.currentFloor;

            // Good candidate if moving same direction & not passed requested floor
            boolean isSameDirectionCandidate =
                    controller.elevatorCar.movingDirection == direction &&
                            ((direction == ElevatorDirection.UP && currentFloor <= requestFloor) ||
                                    (direction == ElevatorDirection.DOWN && currentFloor >= requestFloor));

            int dist = Math.abs(currentFloor - requestFloor);

            if (isSameDirectionCandidate && dist < minDistance) {
                minDistance = dist;
                best = controller;
            }
        }

        // fallback: if not able to choose, pick the idle one
        if (best == null) {
            for (ElevatorController controller : controllers) {
                if(controller.elevatorCar.movingDirection == ElevatorDirection.IDLE) {
                    best = controller;
                    break;
                }
            }
        }
        return best;
    }
}
