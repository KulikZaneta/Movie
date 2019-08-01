package com.project.movie.controller;

import com.project.movie.domain.rest.movieLists.MovieListRest;
import com.project.movie.domain.rest.movieLists.MovieUpcomingRest;
import com.project.movie.domain.rest.movies.MovieRest;
import com.project.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieDbController.class)
public class MovieDbControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @MockBean
    private List<MovieRest> items;

    @Test
    public void shouldGetMovies() throws Exception {
        //Given
        MovieListRest movieListRest = MovieListRest.builder()
                .created_by("testA")
                .description("testB")
                .favorite_count(1)
                .id("2")
                .iso_639_1("testC")
                .item_count(2)
                .name("testD")
                .poster_path("testE")
                .build();
        when(movieService.getList(any())).thenReturn(movieListRest);

        //When&&Then
        mockMvc.perform(get("/movie/list/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.item_count", is(2)))
                .andExpect(jsonPath("$.name", is("testD")))
                .andExpect(jsonPath("$.created_by", is("testA")))
                .andExpect(jsonPath("$.description", is("testB")))
                .andExpect(jsonPath("$.favorite_count", is(1)))
                .andExpect(jsonPath("$.id", is("2")))
                .andExpect(jsonPath("$.iso_639_1", is("testC")))
                .andExpect(jsonPath("$.poster_path", is("testE")));

        verify(movieService, times(1)).getList(String.valueOf(1L));
    }

    @Test
    public void shouldGetMovieUpcoming() throws Exception {
        //Given
        MovieUpcomingRest movieUpcomingRest = MovieUpcomingRest.builder()
                .page(1L)
                .total_pages(2L)
                .total_results(3L)
                .build();
        when(movieService.getMovieUpcoming()).thenReturn(movieUpcomingRest);

        //When & Then
        mockMvc.perform(get("/movie/upcoming").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page", is(1)))
                .andExpect(jsonPath("$.total_pages", is(2)))
                .andExpect(jsonPath("$.total_results", is(3)));

        verify(movieService, times(1)).getMovieUpcoming();
    }
}