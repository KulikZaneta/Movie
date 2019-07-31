package com.project.movie.repository.jpa.movies;

import com.project.movie.domain.jpa.movieLists.MovieUpcoming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieUpcomingRepository extends JpaRepository<MovieUpcoming, Long > {

}
