package com.project.movie.repository.rest;


import com.project.movie.domain.rest.movies.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Slf4j
public class MovieDbDetailsRestRepository {
    @Value("${url.movieDb}")
    private String movieDb;

    @Value("${api.key.movie}")
    private String apiKey;

    public MovieDetailsRest getMovieDetails(Long restMovieId) {
        return new RestTemplate().getForObject(movieDb.concat("/movie/" + restMovieId + "?" + apiKey + "&language=en-US"),MovieDetailsRest.class);
    }

    public SocialMediaRest getSocialMedia(Long restMovieId) {
        return new RestTemplate().getForObject(movieDb.concat("/movie/" + restMovieId + "/external_ids?api_key=" + apiKey),SocialMediaRest.class);
    }

    public KeywordRest getKeywords(Long restMovieId) {
        return new RestTemplate().getForObject(movieDb.concat("/movie/" + restMovieId + "/keywords?api_key=" + apiKey),KeywordRest.class);
    }

    public RelaseDateRest getRelaseDate(Long restMovieId) {
        return new RestTemplate().getForObject(movieDb.concat("/movie/" + restMovieId + "/release_dates?api_key=" + apiKey),RelaseDateRest.class);
    }

    public ReviewsRest getReviews(Long restMovieId) {
        return new RestTemplate().getForObject(movieDb.concat("/movie/" + restMovieId + "/reviews?api_key=" + apiKey + "&language=en-US&page=1"),ReviewsRest.class);
    }
}
