package com.project.movie.service.strategy;

import com.project.movie.domain.jpa.star.wars.StarShips;
import com.project.movie.domain.rest.star.wars.films.FilmTo;
import com.project.movie.domain.rest.star.wars.films.FilmToRest;
import com.project.movie.domain.rest.star.wars.films.FilmsRest;
import com.project.movie.domain.rest.star.wars.starships.StarShipResultRest;
import com.project.movie.service.RapidServiceTest;
import com.project.movie.strategy.service.StarShipsService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class StarShipsServiceTest extends RapidServiceTest<StarShips> {
    @InjectMocks
    private StarShipsService starShipsService;

    @Before
    public void setUp() {
        FilmsRest<StarShipResultRest> starShipRest = new FilmsRest<>();
        FilmTo<StarShipResultRest> toStarShip = new FilmTo<>();
        List<FilmToRest<StarShipResultRest>> listStarShip = new ArrayList<>();
        FilmToRest starShip = new FilmToRest();
        starShip.setResults(new ArrayList());
        listStarShip.add(starShip);
        toStarShip.setTo(listStarShip);
        starShipRest.setContextWrites(toStarShip);

        Mockito.when(rapidRepository.getStarShips()).thenReturn(starShipRest);
        Mockito.when(starShipsRepository.findAll()).thenReturn(new ArrayList<>());
    }

    @Override
    public List<StarShips> getResult() {
        return starShipsService.get();
    }
}
