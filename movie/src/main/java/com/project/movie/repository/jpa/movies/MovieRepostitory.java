package com.project.movie.repository.jpa.movies;

import com.project.movie.domain.jpa.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepostitory extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}
