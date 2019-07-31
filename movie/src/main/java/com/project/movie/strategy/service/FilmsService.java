package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.starWars.Films;
import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.starWars.StarWarsFilmsRepository;
import com.project.movie.repository.rest.RapidRepository;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmsService extends StarWarsStrategy {
    @Autowired
    private RapidRepository rapidRepository;

    @Autowired
    private StarWarsFilmsRepository starWarsFilmsRepository;

    @Autowired
    private RapidMapper rapidMapper;

    protected FilmsService() {
        super(StarWars.FILMS);
    }

    @Override
    public Object get() {
        List< FilmResultRest > filmsRest = rapidRepository.getFilms().getContextWrites().getTo().get(0).getResults();
        List<Films> findStarWars = starWarsFilmsRepository.findAll();
        if (filmsRest.size() == findStarWars.size()) {
            return findStarWars;
        }
        return starWarsFilmsRepository.saveAll(filmsRest.stream()
                .map(rapidMapper::mapToFilm)
                .collect(Collectors.toList()));
    }
}
