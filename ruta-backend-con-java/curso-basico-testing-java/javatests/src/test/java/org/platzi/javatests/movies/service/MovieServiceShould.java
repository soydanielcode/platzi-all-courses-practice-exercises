package org.platzi.javatests.movies.service;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.platzi.javatests.movies.data.MovieRepository;
import org.platzi.javatests.movies.model.Genre;
import org.platzi.javatests.movies.model.Movie;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;


public class MovieServiceShould {
    @Test
    public void return_movies_by_genre() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Harry Potter", 34, Genre.ACTION),
                        new Movie(2, "Barbie", 45, Genre.DRAMA),
                        new Movie(3, "Cars", 67, Genre.COMEDY),
                        new Movie(4, "Son como boys", 34, Genre.THRILLER),
                        new Movie(5, "Men in Blacks", 46, Genre.ACTION)
                        )
        );
        MovieService movieService = new MovieService(movieRepository);
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.ACTION);
        List<Integer> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(1,5)) );
    }
}