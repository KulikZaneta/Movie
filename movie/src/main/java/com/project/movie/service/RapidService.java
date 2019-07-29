package com.project.movie.service;

import com.project.movie.domain.jpa.starWars.*;
import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.domain.rest.starWars.films.FilmsRest;
import com.project.movie.domain.rest.starWars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.domain.rest.starWars.starships.StarShipResultRest;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.starWars.*;
import com.project.movie.repository.rest.RapidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RapidService {
    @Autowired
    private PeoplesRepository peoplesRepository;

    @Autowired
    private PlanetsRepoitory planetsRepoitory;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private StarShipsRepository starShipsRepository;

    @Autowired
    private VehiclesRepository vehiclesRepository;
    @Autowired
    private  StarWarsFilmsRepository starWarsFilmsRepository;

    @Autowired
    private RapidMapper rapidMapper;

    @Autowired
    private RapidRepository rapidRepository;

    public List<Films> getFilms() {
        List<FilmResultRest> filmsRest = rapidRepository.getFilms().getContextWrites().getTo().get(0).getResults();
        List<Films> findStarWars = starWarsFilmsRepository.findAll();
        if (filmsRest.size() == findStarWars.size()) {
            return findStarWars;
        }
        return starWarsFilmsRepository.saveAll(filmsRest.stream()
                .map(rapidMapper::mapToFilm)
                .collect(Collectors.toList()));
    }

    public List<Peoples> getPeoples() {
        List<PeopleResultRest> peopleRest = rapidRepository.getPeoples().getContextWrites().getTo().get(0).getResults();
        List<Peoples> findPeoples = peoplesRepository.findAll();
        if (peopleRest.size() == findPeoples.size()) {
            return findPeoples;
        }
        return peoplesRepository.saveAll(peopleRest.stream()
                .map(rapidMapper::mapToPeople)
                .collect(Collectors.toList()));
    }

    public List<Species> getSpecies() {
        List<SpeciesResultRest> speciesRest = rapidRepository.getSpecies().getContextWrites().getTo().get(0).getResults();
        List<Species> findSpecies = speciesRepository.findAll();
        if (speciesRest.size() == findSpecies.size()) {
            return findSpecies;
        }
        return speciesRepository.saveAll(speciesRest.stream()
                .map(rapidMapper::mapToSpecies)
                .collect(Collectors.toList()));
    }

    public List<Planets> getPlanets() {
        List<PlanetResultRest> planetsRest = rapidRepository.getPlanets().getContextWrites().getTo().get(0).getResults();
        List<Planets> findPlanets = planetsRepoitory.findAll();
        if (planetsRest.size() == findPlanets.size()) {
            return findPlanets;
        }
        return planetsRepoitory.saveAll(planetsRest.stream()
                .map(rapidMapper::mapToPlanets)
                .collect(Collectors.toList()));
    }

    public List<StarShips> getStarShips() {
        List<StarShipResultRest> starShipsRest = rapidRepository.getStarShips().getContextWrites().getTo().get(0).getResults();
        List<StarShips> findStarShips = starShipsRepository.findAll();
        if (starShipsRest.size() == findStarShips.size()) {
            return findStarShips;
        }
        return starShipsRepository.saveAll(starShipsRest.stream()
                .map(rapidMapper::mapToStarShips)
                .collect(Collectors.toList()));
    }


    public List<Vehicles> getVehicles() {
        List<VehicleResultRest> vehiclesRest = rapidRepository.getVehicles().getContextWrites().getTo().get(0).getResults();
        List<Vehicles> findVehicles = vehiclesRepository.findAll();
        if (vehiclesRest.size() == findVehicles.size()) {
            return findVehicles;
        }
        return vehiclesRepository.saveAll(vehiclesRest.stream()
                .map(rapidMapper::mapToVehicles)
                .collect(Collectors.toList()));
    }

}
