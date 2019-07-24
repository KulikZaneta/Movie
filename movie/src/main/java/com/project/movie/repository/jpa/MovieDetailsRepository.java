package com.project.movie.repository.jpa;

import com.project.movie.domain.jpa.movies.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Long> {
    MovieDetails findByRestMovieId(Long id);
}
