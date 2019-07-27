package com.project.movie.service;

import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.domain.rest.starWars.films.FilmsRest;
import com.project.movie.domain.rest.starWars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.domain.rest.starWars.starships.StarShipResultRest;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import com.project.movie.repository.rest.RapidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RapidService {
    @Autowired
    private RapidRepository rapidRepository;

    public FilmsRest<FilmResultRest> getFilms() {
        return rapidRepository.getFilms();
    }

    public FilmsRest<PeopleResultRest> getPeoples() {
        return rapidRepository.getPeoples();
    }

    public FilmsRest<PlanetResultRest> getPlanets() {
        return rapidRepository.getPlanets();
    }

    public FilmsRest<SpeciesResultRest> getSpecies() {
        return rapidRepository.getSpecies();
    }

    public FilmsRest<StarShipResultRest> getStarShips() {
        return rapidRepository.getStarShips();
    }

    public FilmsRest<VehicleResultRest> getVehicles() {
        return rapidRepository.getVehicles();
    }

}
