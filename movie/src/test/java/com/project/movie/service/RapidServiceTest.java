package com.project.movie.service;

import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.domain.rest.starWars.films.FilmsRest;
import com.project.movie.domain.rest.starWars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.domain.rest.starWars.starships.StarShipResultRest;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import com.project.movie.repository.rest.RapidRepository;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RapidServiceTest extends Exception {
    @Autowired
    private RapidService rapidService;

    @MockBean
    private RapidRepository rapidRepository;

    @TestConfiguration
    static class RapidServiceTestContextConfiguration {
        @Bean
        public RapidService rapidService() {
            return new RapidService();
        }
    }

    @Before
    public void setUp(){
        FilmsRest<FilmResultRest> filmsRest = new FilmsRest<>();
        FilmsRest<PeopleResultRest> peopleRest = new FilmsRest<>();
        FilmsRest<PlanetResultRest> planetRest = new FilmsRest<>();
        FilmsRest<SpeciesResultRest> speciesRest = new FilmsRest<>();
        FilmsRest<StarShipResultRest> starShipRest = new FilmsRest<>();
        FilmsRest<VehicleResultRest> vehicleRest = new FilmsRest<>();
        Mockito.when(rapidRepository.getFilms()).thenReturn(filmsRest);
        Mockito.when(rapidRepository.getPeoples()).thenReturn(peopleRest);
        Mockito.when(rapidRepository.getPlanets()).thenReturn(planetRest);
        Mockito.when(rapidRepository.getSpecies()).thenReturn(speciesRest);
        Mockito.when(rapidRepository.getStarShips()).thenReturn(starShipRest);
        Mockito.when(rapidRepository.getVehicles()).thenReturn(vehicleRest);
    }

    @Test
    public void shouldGetFilms() {
        //Given
        FilmsRest<FilmResultRest> filmsRest = new FilmsRest<>();
        //When
        FilmsRest<FilmResultRest> result = rapidService.getFilms();
        //Then
        assertEquals(filmsRest,result);
    }

    @Test
    public void shouldGetPeoples() {
        //Given
        FilmsRest<PeopleResultRest> peopleRest = new FilmsRest<>();
        //When
        FilmsRest<PeopleResultRest> result = rapidService.getPeoples();
        //Then
        assertEquals(peopleRest,result);
    }

    @Test
    public void shouldGetPlanets() {
        //Given
        FilmsRest<PlanetResultRest> planetRest = new FilmsRest<>();
        //When
        FilmsRest<PlanetResultRest> result = rapidService.getPlanets();
        //Then
        assertEquals(planetRest,result);
    }

    @Test
    public void shouldGetSpecies() {
        //Given
        FilmsRest<SpeciesResultRest> speciesRest = new FilmsRest<>();
        //When
        FilmsRest<SpeciesResultRest> result = rapidService.getSpecies();
        //Then
        assertEquals(speciesRest,result);
    }

    @Test
    public void shouldGetStarShips() {
        //Given
        FilmsRest<StarShipResultRest> starShipRest = new FilmsRest<>();
        //When
        FilmsRest<StarShipResultRest> result = rapidService.getStarShips();
        //Then
        assertEquals(starShipRest,result);
    }

    @Test
    public void shouldGetVehicles() {
        //Given
        FilmsRest<VehicleResultRest> vehicleRest = new FilmsRest<>();
        //When
        FilmsRest<VehicleResultRest> result = rapidService.getVehicles();
        //Then
        assertEquals(vehicleRest,result);
    }


}
