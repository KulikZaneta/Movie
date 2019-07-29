package com.project.movie.repository.jpa.starWars;

import com.project.movie.domain.jpa.starWars.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
}
