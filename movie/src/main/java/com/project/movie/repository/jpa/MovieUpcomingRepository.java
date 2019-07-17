package com.project.movie.repository.jpa;

import com.project.movie.domain.jpa.MovieUpcoming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieUpcomingRepository extends JpaRepository<MovieUpcoming, Long > {
}
