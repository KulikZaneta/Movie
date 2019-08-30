package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.star.wars.Species;
import com.project.movie.domain.rest.star.wars.species.SpeciesResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.star.wars.SpeciesRepository;
import com.project.movie.repository.rest.RapidRepository;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsStrategy;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EqualsAndHashCode
public class SpeciesService extends StarWarsStrategy<Species> {
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
    public List<Species> get() {
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
