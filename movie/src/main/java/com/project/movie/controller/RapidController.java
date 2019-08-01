package com.project.movie.controller;

import com.project.movie.domain.jpa.starWars.*;
import com.project.movie.service.RapidService;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsFactoryStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
public class RapidController {
    @Autowired
    private RapidService rapidService;

    @Autowired
    private StarWarsFactoryStrategy starWarsFactoryStrategy;

    @PostMapping("/films")
    public List<Films> getFilms() {
        return (List<Films>) starWarsFactoryStrategy.getByEnum(StarWars.FILMS).get();
    }

    @PostMapping("/peoples")
    public List<Peoples> getPeoples() {
        return (List<Peoples>) starWarsFactoryStrategy.getByEnum(StarWars.PEOPLES).get();
    }

    @PostMapping("/planets")
    public List<Planets> getPlanets() {
        return (List<Planets>) starWarsFactoryStrategy.getByEnum(StarWars.PLANETS).get();
    }

    @PostMapping("/species")
    public List<Species> getSpecies() {
        return (List<Species>) starWarsFactoryStrategy.getByEnum(StarWars.SPECIES).get();
    }

    @PostMapping("/star-ships")
    public List<StarShips> getStarShips() {
        return (List<StarShips>) starWarsFactoryStrategy.getByEnum(StarWars.STARSHIPS).get();
    }

    @PostMapping("/vehicles")
    public List<Vehicles> getVehicles() {
        return (List<Vehicles>) starWarsFactoryStrategy.getByEnum(StarWars.VEHICLES).get();
    }
}
