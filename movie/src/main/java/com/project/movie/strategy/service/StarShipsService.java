package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.star.wars.StarShips;
import com.project.movie.domain.rest.star.wars.starships.StarShipResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.star.wars.StarShipsRepository;
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
public class StarShipsService extends StarWarsStrategy<StarShips> {
    @Autowired
    private RapidRepository rapidRepository;

    @Autowired
    private StarShipsRepository starShipsRepository;

    @Autowired
    private RapidMapper rapidMapper;

    protected StarShipsService() {
        super(StarWars.STARSHIPS);
    }

    @Override
    public List<StarShips> get() {
        List<StarShipResultRest> starShipsRest = rapidRepository.getStarShips().getContextWrites().getTo().get(0).getResults();
        List<StarShips> findStarShips = starShipsRepository.findAll();
        if (starShipsRest.size() == findStarShips.size()) {
            return findStarShips;
        }
        return starShipsRepository.saveAll(starShipsRest.stream()
                .map(rapidMapper::mapToStarShips)
                .collect(Collectors.toList()));
    }
}
