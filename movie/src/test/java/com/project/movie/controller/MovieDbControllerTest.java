package com.project.movie.controller;

import com.project.movie.domain.jpa.movies.Movie;
import com.project.movie.domain.rest.movieLists.MovieListRest;
import com.project.movie.domain.rest.movieLists.MovieUpcomingRest;
import com.project.movie.domain.rest.movies.MovieRest;
import com.project.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieDbController.class)
public class MovieDbControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void getMovies() throws Exception {
        //Given
        MovieListRest movieListRest = new MovieListRest(
        );
    }

    @Test
    public void getMovieUpcoming()throws Exception {
        //Given
        MovieUpcomingRest movieUpcomingRest = new MovieUpcomingRest();
    }
}