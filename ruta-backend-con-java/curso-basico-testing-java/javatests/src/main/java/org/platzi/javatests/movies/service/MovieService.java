package org.platzi.javatests.movies.service;

import org.platzi.javatests.movies.data.MovieRepository;
import org.platzi.javatests.movies.model.Genre;
import org.platzi.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int minutes) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= minutes).collect(Collectors.toList());
    }
}
