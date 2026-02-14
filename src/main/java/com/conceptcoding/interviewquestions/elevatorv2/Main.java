package com.conceptcoding.interviewquestions.elevatorv2;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Enum for Direction
enum Direction {
    UP, DOWN, IDLE
}

// Abstract Request
abstract class Request {
    protected int floor;
    protected Direction direction;

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}

// External Request
class ExternalRequest extends Request {
    public ExternalRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}

// Internal Request
class InternalRequest extends Request {
    private int elevatorId;

    public InternalRequest(int floor, int elevatorId) {
        this.floor = floor;
        this.elevatorId = elevatorId;
        this.direction = Direction.IDLE; // Direction determined by elevator
    }

    public int getElevatorId() {
        return elevatorId;
    }
}

// Dispatch Strategy Interface
interface DispatchStrategy {
    Elevator selectElevator(List<Elevator> elevators, ExternalRequest request);
}

// Nearest Elevator Strategy
class NearestElevatorStrategy implements DispatchStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, ExternalRequest request) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
            if (distance < minDistance &&
                    (elevator.getDirection() == request.getDirection() || elevator.getDirection() == Direction.IDLE)) {
                minDistance = distance;
                best = elevator;
            }
        }
        return best != null ? best : elevators.get(0); // Fallback to first if none match
    }
}

// Elevator Class
class Elevator implements Runnable {
    private int id;
    private int currentFloor;
    private Direction direction = Direction.IDLE;
    private TreeSet<Integer> upRequests = new TreeSet<>(); // Ascending order
    private TreeSet<Integer> downRequests = new TreeSet<>(Collections.reverseOrder()); // Descending order
    private boolean isIdle = true;
    private final Lock lock = new ReentrantLock();
    private final Object monitor = new Object();

    public Elevator(int id, int startingFloor) {
        this.id = id;
        this.currentFloor = startingFloor;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    // Add internal request (from inside elevator)
    public void addInternalRequest(int floor) {
        lock.lock();
        try {
            if (floor > currentFloor) {
                upRequests.add(floor);
            } else if (floor < currentFloor) {
                downRequests.add(floor);
            }
            if (isIdle) {
                wakeUp();
            }
        } finally {
            lock.unlock();
        }
    }

    // Add external request (assigned by controller)
    public void addExternalRequest(int floor, Direction dir) {
        lock.lock();
        try {
            if (dir == Direction.UP) {
                upRequests.add(floor);
            } else if (dir == Direction.DOWN) {
                downRequests.add(floor);
            }
            if (isIdle) {
                wakeUp();
            }
        } finally {
            lock.unlock();
        }
    }

    private void wakeUp() {
        synchronized (monitor) {
            isIdle = false;
            monitor.notify();
        }
    }

    private void processRequests() {
        lock.lock();
        try {
            if (!upRequests.isEmpty() && (direction == Direction.UP || direction == Direction.IDLE)) {
                direction = Direction.UP;
                while (!upRequests.isEmpty()) {
                    Integer nextFloor = upRequests.pollFirst();
                    moveTo(nextFloor);
                    System.out.println("Elevator " + id + " arrived at floor " + currentFloor + " (UP)");
                }
            } else if (!downRequests.isEmpty() && (direction == Direction.DOWN || direction == Direction.IDLE)) {
                direction = Direction.DOWN;
                while (!downRequests.isEmpty()) {
                    Integer nextFloor = downRequests.pollFirst();
                    moveTo(nextFloor);
                    System.out.println("Elevator " + id + " arrived at floor " + currentFloor + " (DOWN)");
                }
            }
            if (upRequests.isEmpty() && downRequests.isEmpty()) {
                direction = Direction.IDLE;
                isIdle = true;
            }
        } finally {
            lock.unlock();
        }
    }

    private void moveTo(int floor) {
        // Simulate movement
        while (currentFloor != floor) {
            if (currentFloor < floor) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            try {
                Thread.sleep(1000); // Simulate time per floor
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Elevator " + id + " moving to " + currentFloor);
        }
    }

    @Override
    public void run() {
        while (true) {
            processRequests();
            if (isIdle) {
                synchronized (monitor) {
                    try {
                        System.out.println("Elevator " + id + " is idle.");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}

// Elevator Controller
class ElevatorController {
    public List<Elevator> elevators;
    public DispatchStrategy strategy;

    public ElevatorController(List<Elevator> elevators, DispatchStrategy strategy) {
        this.elevators = elevators;
        this.strategy = strategy;
    }

    public void dispatchRequest(ExternalRequest request) {
        Elevator selected = strategy.selectElevator(elevators, request);
        if (selected != null) {
            selected.addExternalRequest(request.getFloor(), request.getDirection());
            System.out.println("Dispatched to Elevator " + selected.getId());
        }
    }
}

// Building
class Building {
    private int numFloors;
    private ElevatorController controller;

    public Building(int numFloors, int numElevators, DispatchStrategy strategy) {
        this.numFloors = numFloors;
        List<Elevator> elevators = new ArrayList<>();
        for (int i = 1; i <= numElevators; i++) {
            Elevator elevator = new Elevator(i, 1); // Start at floor 1
            elevators.add(elevator);
            new Thread(elevator).start();
        }
        this.controller = new ElevatorController(elevators, strategy);
    }

    public void requestElevator(int floor, Direction direction) {
        if (floor < 1 || floor > numFloors) {
            throw new IllegalArgumentException("Invalid floor");
        }
        ExternalRequest request = new ExternalRequest(floor, direction);
        controller.dispatchRequest(request);
    }

    // Simulate internal request
    public void internalRequest(int elevatorId, int floor) {
        for (Elevator elevator : controller.elevators) {
            if (elevator.getId() == elevatorId) {
                elevator.addInternalRequest(floor);
                return;
            }
        }
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        DispatchStrategy strategy = new NearestElevatorStrategy();
        Building building = new Building(10, 3, strategy);

        // External requests
        building.requestElevator(5, Direction.UP);
        building.requestElevator(3, Direction.DOWN);

        // Simulate internal request in elevator 1
        building.internalRequest(1, 8);
    }
}