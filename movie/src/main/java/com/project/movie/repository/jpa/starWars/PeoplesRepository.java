package com.project.movie.repository.jpa.starWars;

import com.project.movie.domain.jpa.starWars.Peoples;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeoplesRepository extends JpaRepository<Peoples, Long> {
}
