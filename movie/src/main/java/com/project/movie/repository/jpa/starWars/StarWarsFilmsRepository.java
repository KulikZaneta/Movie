package com.project.movie.repository.jpa.starWars;

import com.project.movie.domain.jpa.starWars.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarWarsFilmsRepository extends JpaRepository<Films, Long> {
}
