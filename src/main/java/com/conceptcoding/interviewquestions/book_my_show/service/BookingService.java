package com.conceptcoding.interviewquestions.book_my_show.service;

import com.conceptcoding.interviewquestions.book_my_show.entities.Booking;
import com.conceptcoding.interviewquestions.book_my_show.entities.Payment;
import com.conceptcoding.interviewquestions.book_my_show.entities.Show;
import com.conceptcoding.interviewquestions.book_my_show.entities.User;
import com.conceptcoding.interviewquestions.book_my_show.enums.PaymentStatus;

import java.util.List;

public class BookingService {

    public Booking book(User user, Show show, List<Integer> seats) {

        if (!show.lockSeats(seats)) {
            throw new RuntimeException("Seat unavailable");
        }

        Payment payment = new Payment();
        if (payment.pay() == PaymentStatus.SUCCESS) {
            show.confirmSeats(seats);
            return new Booking(user, show, seats);
        } else {
            show.releaseSeats(seats);
            throw new RuntimeException("Payment failed");
        }
    }
}
