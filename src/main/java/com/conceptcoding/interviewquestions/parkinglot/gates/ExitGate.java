package com.conceptcoding.interviewquestions.parkinglot.gates;

import com.conceptcoding.interviewquestions.parkinglot.enums.PaymentMode;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpotManager;
import com.conceptcoding.interviewquestions.parkinglot.payment.Payment;
import com.conceptcoding.interviewquestions.parkinglot.payment.PaymentFactory;
import com.conceptcoding.interviewquestions.parkinglot.pricing.CostCalculator;

import java.time.LocalTime;

public class ExitGate {
    private CostCalculator costCalculation;

    public ExitGate(CostCalculator costCalculation) {
        this.costCalculation = costCalculation;
    }

    public void processExit(Ticket ticket, PaymentMode paymentMode) {
        // Calculate parking duration and total fees
        ticket.setExitTime(LocalTime.now());
        double amount = costCalculation.calculateTicketCost(ticket);
        ticket.setAmount(amount);

        // set the Mode of Payment opted by Customer
        Payment paymentInstance = PaymentFactory.getPaymentInstance(paymentMode, amount);
        ticket.setPayment(paymentInstance);

        // Process Payment and Free the Parking Spot
        paymentInstance.processPayment();
        System.out.println("[+] Ticket " + ticket.getTicketNo() + " processed. Cost: $" + amount);
        ParkingSpotManager.getInstance().unParkVehicle(ticket.getParkingSpot());
    }

}