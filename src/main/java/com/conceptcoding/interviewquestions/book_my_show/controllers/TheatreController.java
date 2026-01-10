package com.conceptcoding.interviewquestions.book_my_show.controllers;

import com.conceptcoding.interviewquestions.book_my_show.entities.Movie;
import com.conceptcoding.interviewquestions.book_my_show.entities.Screen;
import com.conceptcoding.interviewquestions.book_my_show.entities.Show;
import com.conceptcoding.interviewquestions.book_my_show.entities.Theatre;
import com.conceptcoding.interviewquestions.book_my_show.enums.City;

import java.time.LocalDate;
import java.util.*;

public class TheatreController {

    private final Map<City, List<Theatre>> cityTheatres = new HashMap<>();

    public void addTheatre(Theatre theatre) {
        cityTheatres
                .computeIfAbsent(theatre.getCity(), c -> new ArrayList<>())
                .add(theatre);
    }

    public List<Theatre> getTheatres(City city, Movie movie, LocalDate date) {
        List<Theatre> theatres = cityTheatres.get(city);
        if (theatres == null) return List.of();
        return theatres.stream()
                .filter(t -> t.getScreens().stream()
                        .anyMatch(s -> s.getShows(date).stream()
                                .anyMatch(show -> show.getMovie().getName().equals(movie.getName()))))
                .toList();
    }

    public List<Show> getShows(Movie movie, LocalDate date, Theatre theatre) {
        List<Show> result = new ArrayList<>();
        for (Screen screen : theatre.getScreens()) {
            for (Show show : screen.getShows(date)) {
                if (show.getMovie().getName().equals(movie.getName())) {
                    result.add(show);
                }
            }
        }
        return result;
    }

    public Set<Movie> getMovies(City city, LocalDate date) {

        Set<Movie> movies = new HashSet<>();

        for (Theatre theatre : cityTheatres.get(city)) {
            for (Screen screen : theatre.getScreens()) {
                for (Show show : screen.getShows(date)) {
                    movies.add(show.getMovie());
                }
            }
        }
        return movies;
    }
}
