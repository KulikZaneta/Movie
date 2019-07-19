package com.project.movie.repository.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.movie.domain.rest.MovieDetailsRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Repository
@Slf4j
public class MovieDbDetailsRestRepository {
    @Value("${url.movieDb}")
    private String movieDb;

    public MovieDetailsRest getMovieDetails(Long restMovieId) {
        String response = new RestTemplate().getForObject(movieDb.concat("/movie/" + restMovieId + "?api_key=a5719ed0a0498b8e7389f828419d49b2&language=en-US"),String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response, MovieDetailsRest.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
