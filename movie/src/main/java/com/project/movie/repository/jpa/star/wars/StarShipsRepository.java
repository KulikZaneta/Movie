package com.project.movie.repository.jpa.star.wars;

import com.project.movie.domain.jpa.star.wars.StarShips;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarShipsRepository extends JpaRepository<StarShips, Long> {
}
