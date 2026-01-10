package com.conceptcoding.interviewquestions.book_my_show.entities;

import java.util.List;
import java.util.UUID;

public class Booking {

    private final UUID bookingId;
    private final User user;
    private final Show show;
    private final List<Integer> seats;

    public Booking(User user, Show show, List<Integer> seats) {
        this.bookingId = UUID.randomUUID();
        this.user = user;
        this.show = show;
        this.seats = seats;
    }

    public UUID getBookingId() {
        return bookingId;
    }
}
