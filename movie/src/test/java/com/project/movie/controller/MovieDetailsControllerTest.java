package com.project.movie.controller;

import com.google.gson.Gson;
import com.project.movie.domain.jpa.movies.SocialMedia;
import com.project.movie.domain.rest.movies.*;
import com.project.movie.service.MovieDetailsService;
import com.project.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieDetailsController.class)
public class MovieDetailsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieDetailsService movieDetailsService;

    @Test
    public void getSocialMedia() throws Exception {
        //Given
        SocialMedia socialMedia = SocialMedia.builder()
                .facebookId("test")
                .imdbId("test1")
                .instagramId("test3")
                .twitterId("test4")
                .id(1L)
                .build();

        when(movieDetailsService.getSocialMedia(284053L)).thenReturn(socialMedia);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(socialMedia);

        //When & Then
        mockMvc.perform(get("/social-media/284053").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdb_id", is("test")))
                .andExpect(jsonPath("$.facebook_id", is("test1")))
                .andExpect(jsonPath("$.instagram_id", is("test2")))
                .andExpect(jsonPath("$.twitter_id", is("test3")))
                .andExpect(jsonPath("$.id", is(284053L)));
        verify(movieDetailsService, times(1)).getSocialMedia(284053L);
        System.out.println(socialMedia);
    }

    @Test
    public void getKeywords() throws Exception {
        //Given
        KeywordRest keywordRest = new KeywordRest(

        );
        when(movieDetailsService.getKeywords(284053L)).thenReturn(keywordRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(keywordRest);

        //When & Then
        mockMvc.perform(get("/keywords/284053").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdb_id", is("test")))
                .andExpect(jsonPath("$.facebook_id", is("test1")))
                .andExpect(jsonPath("$.instagram_id", is("test2")))
                .andExpect(jsonPath("$.twitter_id", is("test3")))
                .andExpect(jsonPath("$.id", is(284053L)));
        verify(movieDetailsService, times(1)).getKeywords(284053L);
        System.out.println(keywordRest);
    }

    @Test
    public void getRelaseDate() throws Exception {
        //Given
        RelaseDateRest relaseDateRest = new RelaseDateRest(

        );
        when(movieDetailsService.getRelaseDate(284053L)).thenReturn(relaseDateRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(relaseDateRest);

        //When & Then
        mockMvc.perform(get("/relase-dates/284053").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdb_id", is("test")))
                .andExpect(jsonPath("$.facebook_id", is("test1")))
                .andExpect(jsonPath("$.instagram_id", is("test2")))
                .andExpect(jsonPath("$.twitter_id", is("test3")))
                .andExpect(jsonPath("$.id", is(284053L)));
        verify(movieDetailsService, times(1)).getRelaseDate(284053L);
        System.out.println(relaseDateRest);

    }

    @Test
    public void getReviews() throws Exception {
        //Given
        ReviewsRest reviewsRest = new ReviewsRest(

        );
        when(movieDetailsService.getReviews(284053L)).thenReturn(reviewsRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(reviewsRest);

        //When & Then
        mockMvc.perform(get("/reviews/284053").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdb_id", is("test")))
                .andExpect(jsonPath("$.facebook_id", is("test1")))
                .andExpect(jsonPath("$.instagram_id", is("test2")))
                .andExpect(jsonPath("$.twitter_id", is("test3")))
                .andExpect(jsonPath("$.id", is(284053L)));
        verify(movieDetailsService, times(1)).getReviews(284053L);
        System.out.println(reviewsRest);
    }

    @Test
    public void getMovieDetailsId() throws Exception {

    }
}