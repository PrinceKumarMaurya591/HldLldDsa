package com.conceptcoding.interviewquestions.parking_lot.payment;

class UPIPayment implements Payment {
    @Override
    public boolean pay(double amount) {
        System.out.println("UPI paid: " + amount);
        return true;
    }
}
