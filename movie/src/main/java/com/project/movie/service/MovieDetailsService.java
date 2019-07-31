package com.project.movie.service;

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

    @Autowired
    private SocialMediaMapper socialMediaMapper;

    @Autowired
    private SocialMediaRepository socialMediaRepository;


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

    public SocialMedia getSocialMedia(Long restMovieId) {
        MovieDetails movieDetails = movieDetailsRepository.findByRestMovieId(restMovieId);
        if (movieDetails != null) {
            if (movieDetails.getSocialMedia() != null && !movieDetails.getSocialMedia().isEmpty()){
                return movieDetails.getSocialMedia().get(0);
            } else {
                SocialMediaRest movieSocialMedia = movieDbDetailsRestRepository.getSocialMedia(restMovieId);
                SocialMedia socialMedia = socialMediaMapper.mapToSocialMedia(movieSocialMedia);
                return socialMediaRepository.save(socialMedia);
            }
        } else {
            SocialMediaRest movieSocialMedia = movieDbDetailsRestRepository.getSocialMedia(restMovieId);
            SocialMedia socialMedia = socialMediaMapper.mapToSocialMedia(movieSocialMedia);
            return socialMediaRepository.save(socialMedia);
        }
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
