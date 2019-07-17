package com.project.movie.listener;

import com.project.movie.domain.jpa.Movie;
import com.project.movie.mapper.MovieMapper;
import com.project.movie.repository.elastic.MovieCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Component
public class MovieListener {
    @Autowired
    private MovieCacheRepository movieCacheRepository;

    @Autowired
    private MovieMapper movieMapper;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void movieListener(List<Movie> movies) {
        System.out.println(movies);
        movieCacheRepository.saveAll(movieMapper.mapToMovieCacheList(movies));

    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void movieListener(Movie movies) {
        System.out.println(movies);
        movieCacheRepository.save(movieMapper.mapToMovieCache(movies));
    }
}
