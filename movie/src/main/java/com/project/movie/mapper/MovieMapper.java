package com.project.movie.mapper;

import com.project.movie.domain.elastic.movies.MovieCache;
import com.project.movie.domain.jpa.movies.Movie;
import com.project.movie.domain.rest.movies.MovieRest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {
    public List<Movie> mapToMovieList(List<MovieRest> movieRests) {
        return movieRests.stream()
                .map(this::mapToMovie)
                .collect(Collectors.toList());
    }

    public Movie mapToMovie(MovieRest movieRest) {
       return Movie.builder()
       .originalLanguage(movieRest.getOriginalLanguage())
       .popularity(movieRest.getPopularity())
       .releaseDate(LocalDate.parse(movieRest.getReleaseDate()))
       .restId(Long.valueOf(movieRest.getId()))
       .title(movieRest.getTitle())
       .build();
    }

    public List<MovieCache> mapToMovieCacheList(List<Movie> movies) {
        return movies.stream()
                .map(this::mapToMovieCache)
                .collect(Collectors.toList());
    }

    public MovieCache mapToMovieCache(Movie movie) {
        return MovieCache.builder()
                .originalLanguage(movie.getOriginalLanguage())
                .popularity(movie.getPopularity())
                .releaseDate(movie.getReleaseDate().toString())
                .restId(movie.getId())
                .title(movie.getTitle())
                .build();
    }
}
