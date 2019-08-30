package com.project.movie.repository.jpa.star.wars;

import com.project.movie.domain.jpa.star.wars.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {
}
