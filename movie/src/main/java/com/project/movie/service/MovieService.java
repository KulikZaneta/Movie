package com.project.movie.service;

import com.project.movie.domain.elastic.movies.MovieCache;
import com.project.movie.domain.jpa.movies.Movie;
import com.project.movie.domain.rest.movie.lists.MovieListRest;
import com.project.movie.domain.rest.movies.MovieRest;
import com.project.movie.domain.rest.movie.lists.MovieUpcomingRest;
import com.project.movie.mapper.MovieMapper;
import com.project.movie.repository.elastic.MovieCacheRepository;
import com.project.movie.repository.jpa.movies.MovieRepostitory;
import com.project.movie.repository.rest.MovieDbRestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class MovieService {
    @Autowired
    private MovieDbRestRepository movieDbRestRepository;

    @Autowired
    private MovieRepostitory movieRepostitory;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieCacheRepository movieCacheRepository;

    @Transactional
    public MovieListRest getList(String listId) {
        MovieListRest movieList = movieDbRestRepository.getMovieList(listId);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> saveIntoDb(movieList.getItems()));
        return movieList;
    }

    @Transactional
    public void saveIntoDb(List<MovieRest> items) {
        movieMapper.mapToMovieList(items).forEach(
                movie -> {
                    MovieCache movieCache = movieCacheRepository.findByTitle(movie.getTitle());
                    if (movieCache == null) {
                        Movie movieDb = movieRepostitory.findByTitle(movie.getTitle());
                        if (movieDb == null) {
                            Movie moviesSave = movieRepostitory.save(movie);
                            movieCacheRepository.save(movieMapper.mapToMovieCache(moviesSave));
                        } else {
                            movieCacheRepository.save(movieMapper.mapToMovieCache(movieDb));
                        }
                    }
                });
    }

    public MovieUpcomingRest getMovieUpcoming() {
        return movieDbRestRepository.getMovieUpcoming();
    }
}
