package com.conceptcoding.interviewquestions.parkinglot.payment;

public class CreditCardPayment implements Payment {
    protected double amount;

    public CreditCardPayment(double amt) {
        this.amount = amt;
    }

    @Override
    public boolean processPayment() {
        System.out.println("\n[+] Paid $" + amount + " using credit card.");
        return true;
    }
}
