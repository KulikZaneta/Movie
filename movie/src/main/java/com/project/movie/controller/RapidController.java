package com.project.movie.controller;

import com.project.movie.domain.jpa.starWars.*;
import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.domain.rest.starWars.films.FilmsRest;
import com.project.movie.domain.rest.starWars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.domain.rest.starWars.starships.StarShipResultRest;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import com.project.movie.service.RapidService;
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

    @PostMapping("/films")
    public List<Films> getFilms() {
        return rapidService.getFilms();
    }

    @PostMapping("/peoples")
    public List<Peoples> getPeoples() {
        return rapidService.getPeoples();
    }

    @PostMapping("/planets")
    public List<Planets> getPlanets() {
        return rapidService.getPlanets();
    }

    @PostMapping("/species")
    public List<Species> getSpecies() {
        return rapidService.getSpecies();
    }

    @PostMapping("/star-ships")
    public List<StarShips> getStarShips() {
        return rapidService.getStarShips();
    }

    @PostMapping("/vehicles")
    public List<Vehicles> getVehicles() {
        return rapidService.getVehicles();
    }


}
