package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.starWars.Planets;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.starWars.PlanetsRepoitory;
import com.project.movie.repository.rest.RapidRepository;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetsService extends StarWarsStrategy {
    @Autowired
    private RapidRepository rapidRepository;

    @Autowired
    private PlanetsRepoitory planetsRepoitory;

    @Autowired
    private RapidMapper rapidMapper;

    protected PlanetsService() {
        super(StarWars.PLANETS);
    }

    @Override
    public Object get() {
        List<PlanetResultRest> planetsRest = rapidRepository.getPlanets().getContextWrites().getTo().get(0).getResults();
        List<Planets> findPlanets = planetsRepoitory.findAll();
        if (planetsRest.size() == findPlanets.size()) {
            return findPlanets;
        }
        return planetsRepoitory.saveAll(planetsRest.stream()
                .map(rapidMapper::mapToPlanets)
                .collect(Collectors.toList()));
    }
}
