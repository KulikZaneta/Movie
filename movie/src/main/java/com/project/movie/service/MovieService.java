package com.project.movie.service;

import com.project.movie.domain.elastic.MovieCache;
import com.project.movie.domain.elastic.MovieDetailsCache;
import com.project.movie.domain.jpa.Movie;
import com.project.movie.domain.rest.MovieListRest;
import com.project.movie.domain.rest.MovieRest;
import com.project.movie.mapper.MovieMapper;
import com.project.movie.repository.elastic.MovieCacheRepository;
import com.project.movie.repository.elastic.MovieDetailsCacheRepository;
import com.project.movie.repository.jpa.MovieRepostitory;
import com.project.movie.repository.rest.MovieDbRestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

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

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public MovieListRest getList(){
        MovieListRest movieList = movieDbRestRepository.getMovieList();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> saveIntoDb(movieList.getItems()));
        return movieList;
    }

    public MovieCache getMovie(String id) {
        return movieCacheRepository.findById(id).orElseThrow(null);
    }


    @Transactional
    public void saveIntoDb(List<MovieRest> items) {
        movieMapper.mapToMovieList(items).stream()
        .map(movie -> {
        //    try {
                Movie moviesSave = movieRepostitory.save(movie);
                movieCacheRepository.save(movieMapper.mapToMovieCache(moviesSave));
                applicationEventPublisher.publishEvent(moviesSave);
                return moviesSave;

            //} catch (Exception e) {
              //  log.error(e.getMessage(), e);
          //  }
           // return null;
        }).filter(Objects::nonNull)
        .collect(Collectors.toList());
    }

}
