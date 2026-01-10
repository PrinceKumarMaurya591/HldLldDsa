package com.conceptcoding.interviewquestions.book_my_show.controllers;

import com.conceptcoding.interviewquestions.book_my_show.entities.Movie;
import com.conceptcoding.interviewquestions.book_my_show.entities.Screen;
import com.conceptcoding.interviewquestions.book_my_show.entities.Show;
import com.conceptcoding.interviewquestions.book_my_show.entities.Theatre;
import com.conceptcoding.interviewquestions.book_my_show.enums.City;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    private final Map<City, List<Theatre>> cityTheatres = new HashMap<>();

    public void addTheatre(Theatre theatre) {
        cityTheatres
                .computeIfAbsent(theatre.getCity(), c -> new ArrayList<>())
                .add(theatre);
    }

    public List<Theatre> getTheatres(City city) {
        return cityTheatres.getOrDefault(city, List.of());
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
}
