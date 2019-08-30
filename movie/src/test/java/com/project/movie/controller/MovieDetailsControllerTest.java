package com.project.movie.controller;

import com.project.movie.domain.elastic.movies.MovieDetailsCache;
import com.project.movie.domain.jpa.movies.MovieDetails;
import com.project.movie.domain.jpa.movies.SocialMedia;
import com.project.movie.domain.rest.movies.*;
import com.project.movie.mapper.MovieDetailsMapper;
import com.project.movie.mapper.SocialMediaMapper;
import com.project.movie.repository.elastic.MovieDetailsCacheRepository;
import com.project.movie.repository.jpa.movies.MovieDetailsRepository;
import com.project.movie.repository.jpa.movies.SocialMediaRepository;
import com.project.movie.repository.rest.MovieDbDetailsRestRepository;
import com.project.movie.service.MovieDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

    @MockBean
    private MovieDetailsCacheRepository movieDetailsCacheRepository;

    @MockBean
    private MovieDbDetailsRestRepository movieDbDetailsRestRepository;

    @MockBean
    private MovieDetailsRepository movieDetailsRepository;

    @MockBean
    private MovieDetailsMapper movieDetailsMapper;

    @MockBean
    private SocialMediaMapper socialMediaMapper;

    @MockBean
    private SocialMediaRepository socialMediaRepository;


    @Test
    public void shouldGetSocialMedia() throws Exception {
        MovieDetails movieDetails = new MovieDetails();
    //Given
    SocialMedia socialMedia = new SocialMedia(
            "a", "b", "c", "d", 1L, movieDetails);

    when(movieDetailsService.getSocialMedia(anyLong())).thenReturn(socialMedia);

    //When & Then
            mockMvc.perform(get("/movie-details/social-media/1").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdbId", is("a")))
                .andExpect(jsonPath("$.facebookId", is("b")))
                .andExpect(jsonPath("$.instagramId", is("c")))
                .andExpect(jsonPath("$.twitterId", is("d")))
                .andExpect(jsonPath("$.id", is(1)));

        verify(movieDetailsService, times(1)).getSocialMedia(1L);
}

    @Test
    public void shouldGetKeywords() throws Exception {
        //Given
        KeywordRest keywordRest =  KeywordRest.builder()
                .id(284053L)
                .keyword(MovieKeywordRest.builder()
                        .id(1L)
                        .name("A")
                        .build())
                .build();
        when(movieDetailsService.getKeywords(284053L)).thenReturn(keywordRest);

        //When & Then
        mockMvc.perform(get("/movie-details/keywords/284053").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(284053)));
        verify(movieDetailsService, times(1)).getKeywords(284053L);
        System.out.println(keywordRest);
    }

    @Test
    public void shouldGetRelaseDate() throws Exception {
        //Given
        RelaseDateRest relaseDateRest = RelaseDateRest.builder()
                .id(284053L)
                .result(MovieResultsRest.builder()
                        .iso("a")
                .build())
                .build();
        when(movieDetailsService.getRelaseDate(284053L)).thenReturn(relaseDateRest);

        //When & Then
        mockMvc.perform(get("/movie-details/relase-dates/284053").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(284053)));
        verify(movieDetailsService, times(1)).getRelaseDate(284053L);
    }

    @Test
    public void shouldGetReviews() throws Exception {
        //Given
        ReviewsRest reviewsRest =  ReviewsRest.builder()
                .id(284053L)
                .page("1")
                .totalPages(1L)
                .totalResults(1L)
                .result(DetailsResultRest.builder()
                        .author("a")
                        .content("b")
                        .id("1")
                        .url("v")
                        .build())
                .build();
        when(movieDetailsService.getReviews(284053L)).thenReturn(reviewsRest);

        //When & Then
        mockMvc.perform(get("/movie-details/reviews/284053").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(284053)));
        verify(movieDetailsService, times(1)).getReviews(284053L);
    }

    @Test
    public void shouldGetMovieDetailsId() throws Exception {
        //Given
        MovieDetailsCache movieDetailsCache = MovieDetailsCache.builder()
                .adult(true)
                .originalLanguage("a")
                .originalTitle("b")
                .popularity(3.0)
                .releaseDate("d")
                .restMovieId(1L)
                .runtime(1.0)
                .title("e")
                .voteAverage(3L)
                .id("4")
                .build();

        when(movieDetailsService.getSaveMovieDetails(4L)).thenReturn(movieDetailsCache);

        //When & Then
        mockMvc.perform(get("/movie-details/4").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("4")));
        verify(movieDetailsService, times(1)).getSaveMovieDetails(4L);
        System.out.println(movieDetailsCache);


    }
}