package com.project.movie.service;

import com.project.movie.domain.elastic.movies.MovieDetailsCache;
import com.project.movie.domain.jpa.movies.MovieDetails;
import com.project.movie.domain.rest.movies.*;
import com.project.movie.mapper.MovieDetailsMapper;
import com.project.movie.repository.elastic.MovieDetailsCacheRepository;
import com.project.movie.repository.jpa.MovieDetailsRepository;
import com.project.movie.repository.rest.MovieDbDetailsRestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieDetailsService {
    @Autowired
    private MovieDetailsCacheRepository movieDetailsCacheRepository;

    @Autowired
    private MovieDbDetailsRestRepository movieDbDetailsRestRepository;

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    @Autowired
    private MovieDetailsMapper movieDetailsMapper;


    public MovieDetailsCache getSaveMovieDetails(Long id) {
        MovieDetailsCache movieCache = movieDetailsCacheRepository.findByRestMovieId(id);
        if (movieCache != null) {
            return movieCache;
        } else {
            MovieDetails movieDbDetails = movieDetailsRepository.findByRestMovieId(id);
            if (movieDbDetails != null) {
                return movieDetailsCacheRepository.save(movieDetailsMapper.mapToMovieDetailsCache(movieDbDetails));
            } else {
                MovieDetailsRest movieRest = movieDbDetailsRestRepository.getMovieDetails(id);
                movieDbDetails = movieDetailsRepository.save(movieDetailsMapper.mapToMovieDetails(movieRest));
                return movieDetailsCacheRepository.save(movieDetailsMapper.mapToMovieDetailsCache(movieDbDetails));
            }
        }
    }

    public SocialMediaRest getSocialMedia(Long restMovieId) {
        return movieDbDetailsRestRepository.getSocialMedia(restMovieId);
    }

    public KeywordRest getKeywords(Long restMovieId) {
        return movieDbDetailsRestRepository.getKeywords(restMovieId);
    }

    public RelaseDateRest getRelaseDate(Long restMovieId) {
        return movieDbDetailsRestRepository.getRelaseDate(restMovieId);
    }

    public ReviewsRest getReviews(Long restMovieId) {
        return movieDbDetailsRestRepository.getReviews(restMovieId);
    }

}
