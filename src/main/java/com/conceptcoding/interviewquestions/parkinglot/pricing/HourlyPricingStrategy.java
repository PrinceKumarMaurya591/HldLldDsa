package com.conceptcoding.interviewquestions.parkinglot.pricing;

import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

import java.util.Random;

public class HourlyPricingStrategy implements PricingStrategy {
    private double costPerHour;

    public HourlyPricingStrategy(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public double calculateCost(Ticket ticket) {
        // double hours = (ticket.getExitTime().getHour() - ticket.getEntryTime().getHour());
        double hours = getParkingTimeInHours();
        return ticket.getParkingSpot().getPrice() + hours * costPerHour;
    }

    private int getParkingTimeInHours() {
        Random random = new Random();
        return random.nextInt(2, 5);
    }
}