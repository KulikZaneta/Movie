package com.project.movie.repository.jpa.starWars;

import com.project.movie.domain.jpa.starWars.StarShips;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarShipsRepository extends JpaRepository<StarShips, Long> {
}
