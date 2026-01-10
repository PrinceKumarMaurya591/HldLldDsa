package com.conceptcoding.interviewquestions.book_my_show.controllers;

import com.conceptcoding.interviewquestions.book_my_show.entities.Movie;
import com.conceptcoding.interviewquestions.book_my_show.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    private final Map<City, List<Movie>> cityMovies = new HashMap<>();

    public void addMovie(City city, Movie movie) {
        cityMovies.computeIfAbsent(city, c -> new ArrayList<>()).add(movie);
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityMovies.getOrDefault(city, List.of());
    }
}
