package com.project.movie.controller;

import com.project.movie.domain.elastic.movies.MovieDetailsCache;
import com.project.movie.domain.jpa.movies.SocialMedia;
import com.project.movie.domain.rest.movies.*;
import com.project.movie.service.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-details")
public class MovieDetailsController {
    @Autowired
    private MovieDetailsService movieDetailsService;

    @GetMapping("/social-media/{restMovieId}")
    public SocialMedia getSocialMedia(@PathVariable Long restMovieId) {
        return movieDetailsService.getSocialMedia(restMovieId);
    }

    @GetMapping("/keywords/{restMovieId}")
    public KeywordRest getKeywords(@PathVariable Long restMovieId) {
        return movieDetailsService.getKeywords(restMovieId);
    }

    @GetMapping("/relase-dates/{restMovieId}")
    public RelaseDateRest getRelaseDate(@PathVariable Long restMovieId) {
        return movieDetailsService.getRelaseDate(restMovieId);
    }

    @GetMapping("/reviews/{restMovieId}")
    public ReviewsRest getReviews(@PathVariable Long restMovieId) {
        return movieDetailsService.getReviews(restMovieId);
    }

    @GetMapping("/{id}")
    public MovieDetailsCache getMovieDetailsId(@PathVariable Long id) {
        return movieDetailsService.getSaveMovieDetails(id);
    }
}
