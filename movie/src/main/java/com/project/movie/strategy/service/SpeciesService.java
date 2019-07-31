package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.starWars.Species;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.starWars.SpeciesRepository;
import com.project.movie.repository.jpa.starWars.StarWarsFilmsRepository;
import com.project.movie.repository.rest.RapidRepository;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpeciesService extends StarWarsStrategy {
    @Autowired
    private RapidRepository rapidRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private RapidMapper rapidMapper;

    protected SpeciesService() {
        super(StarWars.SPECIES);
    }

    @Override
    public Object get() {
        List<SpeciesResultRest> speciesRest = rapidRepository.getSpecies().getContextWrites().getTo().get(0).getResults();
        List<Species> findSpecies = speciesRepository.findAll();
        if (speciesRest.size() == findSpecies.size()) {
            return findSpecies;
        }
        return speciesRepository.saveAll(speciesRest.stream()
                .map(rapidMapper::mapToSpecies)
                .collect(Collectors.toList()));
    }
}
