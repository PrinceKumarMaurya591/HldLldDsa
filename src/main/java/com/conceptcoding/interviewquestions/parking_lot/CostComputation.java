package com.conceptcoding.interviewquestions.parking_lot;

import java.time.Duration;
import java.time.LocalDateTime;

public class CostComputation {

    private final PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double compute(Ticket ticket) {
        long minutes = Duration.between(
                ticket.getEntryTime(),
                LocalDateTime.now()
        ).toMinutes();

        return pricingStrategy.calculate(minutes);
    }
}
