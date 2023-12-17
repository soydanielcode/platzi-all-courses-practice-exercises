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

    public Collection<Movie> findMoviesByName(String name) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase()
                        .contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie movieTemplate) {
        if (movieTemplate.getName() != null && movieTemplate.getMinutes() != null && movieTemplate.getGenre() != null) {
            return movieRepository.findAll().stream()
                    .filter(movie -> movie.getName().toLowerCase()
                            .contains(movieTemplate.getName().toLowerCase()) &&
                            movie.getMinutes() <= movieTemplate.getMinutes() &&
                            String.valueOf(movie.getGenre()).contains(String.valueOf(movieTemplate.getGenre())) )
                    .collect(Collectors.toList());
        }
        if (movieTemplate.getGenre() != null && movieTemplate.getMinutes() != null) {
            return movieRepository.findAll().stream()
                    .filter(movie -> String.valueOf(movie.getGenre()).toLowerCase()
                            .contains(String.valueOf(movieTemplate.getGenre()).toLowerCase()) && movie.getMinutes() <= movieTemplate.getMinutes())
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
