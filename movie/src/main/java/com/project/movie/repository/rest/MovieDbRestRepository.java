package com.project.movie.repository.rest;

import com.project.movie.domain.rest.movieLists.MovieListRest;
import com.project.movie.domain.rest.movies.MovieUpcomingRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Repository
public class MovieDbRestRepository {
    @Value("${url.movieDb}")
    private String movieDb;

    @Value("${movie.api.key}")
    private String apiKey;

    //movieListsRepository
    public MovieListRest getMovieList(String listId) {//dodanie parametru(wraz z movieservice)
        return new RestTemplate().getForObject(movieDb.concat("/list/" + listId + "?api_key=a5719ed0a0498b8e7389f828419d49b2&language=en-US"),MovieListRest.class);
    }

    public MovieUpcomingRest getMovieUpcoming() {
        return new RestTemplate().getForObject(movieDb.concat("/movie/upcoming?" + apiKey + "&language=en-US&page=1"),MovieUpcomingRest.class);
    }
}

