package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.star.wars.Films;
import com.project.movie.domain.rest.star.wars.films.FilmResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.star.wars.StarWarsFilmsRepository;
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
public class FilmsService extends StarWarsStrategy<Films> {
    @Autowired
    private RapidRepository rapidRepository;

    @Autowired
    private StarWarsFilmsRepository starWarsFilmsRepository;

    @Autowired
    private RapidMapper rapidMapper;

    public FilmsService() {
        super(StarWars.FILMS);
    }

    @Override
    public List<Films> get() {
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
