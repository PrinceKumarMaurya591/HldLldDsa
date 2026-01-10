package com.conceptcoding.interviewquestions.book_my_show;

import com.conceptcoding.interviewquestions.book_my_show.controllers.MovieController;
import com.conceptcoding.interviewquestions.book_my_show.controllers.TheatreController;
import com.conceptcoding.interviewquestions.book_my_show.entities.*;
import com.conceptcoding.interviewquestions.book_my_show.enums.City;
import com.conceptcoding.interviewquestions.book_my_show.enums.SeatCategory;
import com.conceptcoding.interviewquestions.book_my_show.service.BookingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class BookMyShowApp {

    public static void main(String[] args) {

        MovieController movieController = new MovieController();
        TheatreController theatreController = new TheatreController();
        BookingService bookingService = new BookingService();

        // User
        User user = new User("U1", "Rahul");

        // Movie
        Movie baahubali = new Movie("BAAHUBALI");
        movieController.addMovie(City.BANGALORE, baahubali);

        // Seats
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            seats.add(new Seat(i, SeatCategory.SILVER));
        }

        // Screen
        Screen screen = new Screen(1, seats);

        // Show (DATE-WISE)
        Show showToday = new Show(
                baahubali,
                screen,
                LocalDate.now(),
                LocalTime.of(8, 0)
        );
        screen.addShow(showToday);

        // Theatre
        Theatre inox = new Theatre("INOX", City.BANGALORE, List.of(screen));
        theatreController.addTheatre(inox);

        // ===== USER FLOW =====
        City city = City.BANGALORE;
        Movie movie = movieController.getMoviesByCity(city).get(0);
        LocalDate date = LocalDate.now();
        Theatre theatre = theatreController.getTheatres(city).get(0);
        Show show =
                theatreController
                        .getShows(movie, date, theatre)
                        .get(0);

        Booking booking =
                bookingService.book(user, show, List.of(1, 2, 3));

        System.out.println("BOOKING SUCCESS: " + booking.getBookingId());
    }
}
