package com.project.movie.repository.jpa;

import com.project.movie.domain.jpa.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepostitory extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);

}
