package com.project.movie.service;

import com.project.movie.domain.jpa.movieLists.MovieUpcoming;
import com.project.movie.domain.rest.authentication.GuestSessionRest;
import com.project.movie.domain.rest.authentication.TokenRest;
import com.project.movie.domain.rest.movieLists.MovieListRest;
import com.project.movie.domain.rest.movieLists.MovieUpcomingRest;
import com.project.movie.mapper.MovieMapper;
import com.project.movie.repository.elastic.MovieCacheRepository;
import com.project.movie.repository.jpa.movies.MovieRepostitory;
import com.project.movie.repository.rest.MovieDbRestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieDbRestRepository movieDbRestRepository;

    @MockBean
    private MovieRepostitory movieRepostitory;

    @MockBean
    private MovieMapper movieMapper;

    @MockBean
    private MovieCacheRepository movieCacheRepository;

    @TestConfiguration
    static class MovieServiceTestContextConfiguration {
        @Bean
        public MovieService movieService() {
            return new MovieService();
        }
    }

    @Before
    public void setUp() {
        MovieListRest movieListRest = new MovieListRest();
        MovieUpcomingRest movieUpcomingRest = new MovieUpcomingRest();
        Mockito.when(movieDbRestRepository.getMovieList("1")).thenReturn(movieListRest);
        Mockito.when(movieDbRestRepository.getMovieList("2")).thenReturn(null);
        Mockito.when(movieDbRestRepository.getMovieUpcoming()).thenReturn(movieUpcomingRest);
    }

    @Test
    public void shouldGetMovieList() {
        //Given
        MovieListRest movieListRest = new MovieListRest();
        //When
        MovieListRest result = movieService.getList("1");
        //Then
        assertEquals(movieListRest,result);
    }

    @Test
    public void shouldGetMovieUpcoming() {
        //Given
        MovieUpcomingRest movieUpcomingRest = new MovieUpcomingRest();
        //When
        MovieUpcomingRest result = movieService.getMovieUpcoming();
        //Then
        assertEquals(movieUpcomingRest,result);
    }



}
