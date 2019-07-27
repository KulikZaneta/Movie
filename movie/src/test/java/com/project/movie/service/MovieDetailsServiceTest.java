package com.project.movie.service;

import com.project.movie.domain.elastic.movies.MovieDetailsCache;
import com.project.movie.domain.jpa.movies.MovieDetails;
import com.project.movie.domain.rest.movies.*;
import com.project.movie.mapper.MovieDetailsMapper;
import com.project.movie.repository.elastic.MovieDetailsCacheRepository;
import com.project.movie.repository.jpa.MovieDetailsRepository;
import com.project.movie.repository.rest.MovieDbDetailsRestRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DataJpaTest
public class MovieDetailsServiceTest {
    @Autowired
    private MovieDetailsService movieDetailsService;

    @MockBean
    private MovieDbDetailsRestRepository movieDbDetailsRestRepository;

    @MockBean
    private MovieDetailsCacheRepository movieDetailsCacheRepository;

    @MockBean
    private MovieDetailsRepository movieDetailsRepository;

    @MockBean
    private MovieDetailsMapper movieDetailsMapper;


    @TestConfiguration
    static class MovieDetailsServiceTestContextConfiguration {
        @Bean
        public MovieDetailsService movieDetailsService() {
            return new MovieDetailsService();
        }
    }

    @Before
    public void setUp() {
        MovieDetailsRest movieDetailsRest = new MovieDetailsRest();
        SocialMediaRest socialMediaRest = new SocialMediaRest();
        KeywordRest keywordRest = new KeywordRest();
        RelaseDateRest relaseDateRest = new RelaseDateRest();
        ReviewsRest reviewsRest = new ReviewsRest();
        Mockito.when(movieDbDetailsRestRepository.getSocialMedia(1L)).thenReturn(socialMediaRest);
        Mockito.when(movieDbDetailsRestRepository.getKeywords(1L)).thenReturn(keywordRest);
        Mockito.when(movieDbDetailsRestRepository.getRelaseDate(1L)).thenReturn(relaseDateRest);
        Mockito.when(movieDbDetailsRestRepository.getReviews(1L)).thenReturn(reviewsRest);
        Mockito.when(movieDbDetailsRestRepository.getMovieDetails(1L)).thenReturn(movieDetailsRest);
        Mockito.when(movieDbDetailsRestRepository.getSocialMedia(2L)).thenReturn(null);
        Mockito.when(movieDbDetailsRestRepository.getKeywords(2L)).thenReturn(null);
        Mockito.when(movieDbDetailsRestRepository.getRelaseDate(2L)).thenReturn(null);
        Mockito.when(movieDbDetailsRestRepository.getReviews(2L)).thenReturn(null);
        Mockito.when(movieDbDetailsRestRepository.getMovieDetails(2L)).thenReturn(null);
        Mockito.when(movieDetailsCacheRepository.findByRestMovieId(2L)).thenReturn(new MovieDetailsCache());
        Mockito.when(movieDetailsRepository.findByRestMovieId(2L)).thenReturn(new MovieDetails());
        Mockito.when(movieDetailsCacheRepository.findByRestMovieId(3L)).thenReturn(null);
        Mockito.when(movieDetailsMapper.mapToMovieDetailsCache(any(MovieDetails.class))).thenReturn(new MovieDetailsCache());
        Mockito.when(movieDetailsCacheRepository.save(any(MovieDetailsCache.class))).thenReturn(new MovieDetailsCache());


    }

    @Test
    public void shouldGetSocialMedia() {
        //Given
        SocialMediaRest socialMediaRest = new SocialMediaRest();
        //When
        SocialMediaRest result = movieDetailsService.getSocialMedia(1L);
        //Then
        assertEquals(socialMediaRest, result);
    }

    @Test
    public void shouldEmptyGetSocialMedia() {
        //Given
        SocialMediaRest socialMediaRest = null;
        //When
        SocialMediaRest result = movieDetailsService.getSocialMedia(2L);
        //Then
        assertEquals(socialMediaRest, result);
    }

    @Test
    public void shouldGetKeywords() {
        //Given
        KeywordRest keywordRest = new KeywordRest();
        //When
        KeywordRest result = movieDetailsService.getKeywords(1L);
        //Then
        assertEquals(keywordRest, result);
    }

    @Test
    public void shouldEmptyGetKeywords() {
        //Given
        KeywordRest keywordRest = null;
        //When
        KeywordRest result = movieDetailsService.getKeywords(2L);
        //Then
        assertEquals(keywordRest, result);
    }

    @Test
    public void shouldGetRelaseDate() {
        //Given
        RelaseDateRest relaseDateRest = new RelaseDateRest();
        //When
        RelaseDateRest result = movieDetailsService.getRelaseDate(1L);
        //Then
        assertEquals(relaseDateRest, result);
    }

    @Test
    public void shouldEmptyGetRelaseDate() {
        //Given
        RelaseDateRest relaseDateRest = null;
        //When
        RelaseDateRest result = movieDetailsService.getRelaseDate(2L);
        //Then
        assertEquals(relaseDateRest, result);
    }

    @Test
    public void shouldGetReviews() {
        //Given
        ReviewsRest reviewsRest = new ReviewsRest();
        //When
        ReviewsRest result = movieDetailsService.getReviews(1L);
        //Then
        assertEquals(reviewsRest, result);
    }

    @Test
    public void shouldEmptyGetReviews() {
        //Given
        ReviewsRest reviewsRest = null;
        //When
        ReviewsRest result = movieDetailsService.getReviews(2L);
        //Then
        assertEquals(reviewsRest, result);
    }

    @Test
    public void shouldGetMovieDetails() {
        //Given
        MovieDetailsCache movieDetailsCache = new MovieDetailsCache();
        //When
        MovieDetailsCache result = movieDetailsService.getSaveMovieDetails(2L);
        //Then
        assertEquals(movieDetailsCache, result);
    }

    @Test
    public void shouldGetMovieDetailsCache() {
        //Given
        MovieDetailsCache movieDetailsCache = new MovieDetailsCache();
        //When
        MovieDetailsCache result = movieDetailsService.getSaveMovieDetails(3L);
        //Then
        assertEquals(movieDetailsCache, result);
    }


}
