package com.conceptcoding.interviewquestions.parkinglot.payment;

public class UPIPayment implements Payment {
    protected double amount;

    public UPIPayment(double amt) {
        this.amount = amt;
    }

    @Override
    public boolean processPayment() {
        System.out.println("\n[+] Paid $" + amount + " using UPI.");
        return true;
    }
}
