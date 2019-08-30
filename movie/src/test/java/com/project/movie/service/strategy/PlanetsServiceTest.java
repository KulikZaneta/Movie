package com.project.movie.service.strategy;

import com.project.movie.domain.jpa.star.wars.Planets;
import com.project.movie.domain.rest.star.wars.films.FilmTo;
import com.project.movie.domain.rest.star.wars.films.FilmToRest;
import com.project.movie.domain.rest.star.wars.films.FilmsRest;
import com.project.movie.domain.rest.star.wars.plantes.PlanetResultRest;
import com.project.movie.service.RapidServiceTest;
import com.project.movie.strategy.service.PlanetsService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PlanetsServiceTest extends RapidServiceTest<Planets> {
    @InjectMocks
    private PlanetsService planetsService;

    @Before
    public void setUp() {
        FilmsRest<PlanetResultRest> planetRest = new FilmsRest<>();
        FilmTo<PlanetResultRest> toPlanet = new FilmTo<>();
        List<FilmToRest<PlanetResultRest>> listPlanet = new ArrayList<>();
        FilmToRest planet = new FilmToRest();
        planet.setResults(new ArrayList());
        listPlanet.add(planet);
        toPlanet.setTo(listPlanet);
        planetRest.setContextWrites(toPlanet);

        Mockito.when(rapidRepository.getPlanets()).thenReturn(planetRest);
        Mockito.when(planetsRepoitory.findAll()).thenReturn(new ArrayList<>());
    }

    @Override
    public List<Planets> getResult() {
        return planetsService.get();
    }
}

