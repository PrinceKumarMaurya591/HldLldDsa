package com.conceptcoding.interviewquestions.parking_lot;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public double calculate(long minutes) {
        return 100;
    }
}
