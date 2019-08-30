package com.project.movie.controller;

import com.project.movie.domain.rest.movie.lists.MovieListRest;
import com.project.movie.domain.rest.movie.lists.MovieUpcomingRest;
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
                .createdBy("testA")
                .description("testB")
                .favoriteCount(1)
                .id("2")
                .iso("testC")
                .itemCount(2)
                .name("testD")
                .posterPath("testE")
                .build();
        when(movieService.getList(any())).thenReturn(movieListRest);

        //When&&Then
        mockMvc.perform(get("/movie/list/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itemCount", is(2)))
                .andExpect(jsonPath("$.name", is("testD")))
                .andExpect(jsonPath("$.createdBy", is("testA")))
                .andExpect(jsonPath("$.description", is("testB")))
                .andExpect(jsonPath("$.favoriteCount", is(1)))
                .andExpect(jsonPath("$.id", is("2")))
                .andExpect(jsonPath("$.iso", is("testC")))
                .andExpect(jsonPath("$.posterPath", is("testE")));

        verify(movieService, times(1)).getList(String.valueOf(1L));
    }

    @Test
    public void shouldGetMovieUpcoming() throws Exception {
        //Given
        MovieUpcomingRest movieUpcomingRest = MovieUpcomingRest.builder()
                .page(1L)
                .totalPages(2L)
                .totalResults(3L)
                .build();
        when(movieService.getMovieUpcoming()).thenReturn(movieUpcomingRest);

        //When & Then
        mockMvc.perform(get("/movie/upcoming").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page", is(1)))
                .andExpect(jsonPath("$.totalPages", is(2)))
                .andExpect(jsonPath("$.totalResults", is(3)));

        verify(movieService, times(1)).getMovieUpcoming();
    }
}