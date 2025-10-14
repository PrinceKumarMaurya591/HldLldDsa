package com.conceptcoding.interviewquestions.parkinglot.pricing;

import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

import java.util.Random;

public class PerMinutePricingStrategy implements PricingStrategy {
    private double costPerMinute;

    public PerMinutePricingStrategy(double costPerMinute) {
        this.costPerMinute = costPerMinute;
    }

    @Override
    public double calculateCost(Ticket ticket) {
        // double minutes = (ticket.getExitTime().getMinute() - ticket.getEntryTime().getMinute());
        int minutes = getParkingTimeInMinutes();
        return ticket.getParkingSpot().getPrice() + minutes * costPerMinute;
    }

    private int getParkingTimeInMinutes() {
        Random random = new Random();
        return random.nextInt(10, 91);
    }
}