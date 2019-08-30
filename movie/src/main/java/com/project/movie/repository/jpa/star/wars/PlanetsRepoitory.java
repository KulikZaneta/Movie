package com.project.movie.repository.jpa.star.wars;

import com.project.movie.domain.jpa.star.wars.Planets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetsRepoitory extends JpaRepository<Planets, Long> {
}
