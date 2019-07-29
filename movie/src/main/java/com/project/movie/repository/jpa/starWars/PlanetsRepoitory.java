package com.project.movie.repository.jpa.starWars;

import com.project.movie.domain.jpa.starWars.Planets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetsRepoitory extends JpaRepository<Planets, Long> {
}
