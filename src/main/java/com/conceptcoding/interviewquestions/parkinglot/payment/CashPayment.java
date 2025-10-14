package com.conceptcoding.interviewquestions.parkinglot.payment;

public class CashPayment implements Payment {
    protected double amount;

    public CashPayment(double amt) {
        this.amount = amt;
    }

    @Override
    public boolean processPayment() {
        System.out.println("\n[+] Paid $" + amount + " using cash.");
        return true;
    }
}
