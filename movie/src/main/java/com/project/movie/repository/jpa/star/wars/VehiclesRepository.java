package com.project.movie.repository.jpa.star.wars;

import com.project.movie.domain.jpa.star.wars.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
}
