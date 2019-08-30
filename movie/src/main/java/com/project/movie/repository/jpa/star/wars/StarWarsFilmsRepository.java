package com.project.movie.repository.jpa.star.wars;

import com.project.movie.domain.jpa.star.wars.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarWarsFilmsRepository extends JpaRepository<Films, Long> {
}
