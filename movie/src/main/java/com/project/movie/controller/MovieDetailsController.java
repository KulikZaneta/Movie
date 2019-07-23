package com.project.movie.controller;

import com.project.movie.domain.elastic.MovieDetailsCache;
import com.project.movie.domain.rest.movies.KeywordRest;
import com.project.movie.domain.rest.movies.SocialMediaRest;
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
    public SocialMediaRest getSocialMedia(@PathVariable Long restMovieId) {
        return movieDetailsService.getSocialMedia(restMovieId);
    }

    @GetMapping("/keywords/{restMovieId}")
    public KeywordRest getKeywords(@PathVariable Long restMovieId) {
        return movieDetailsService.getKeywords(restMovieId);
    }

    @GetMapping("/{id}")
    public MovieDetailsCache getMovieDetailsId(@PathVariable Long id) {
        return movieDetailsService.getMovieDetails(id);
    }
}
