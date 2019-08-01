package com.project.movie.service;

import com.project.movie.domain.jpa.starWars.*;
import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.domain.rest.starWars.films.FilmTo;
import com.project.movie.domain.rest.starWars.films.FilmToRest;
import com.project.movie.domain.rest.starWars.films.FilmsRest;
import com.project.movie.domain.rest.starWars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.domain.rest.starWars.starships.StarShipResultRest;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.starWars.*;
import com.project.movie.repository.rest.RapidRepository;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RapidServiceTest extends Exception {
    @Autowired
    private RapidService rapidService;

    @MockBean
    private RapidRepository rapidRepository;

    @MockBean
    private PeoplesRepository peoplesRepository;

    @MockBean
    private PlanetsRepoitory planetsRepoitory;

    @MockBean
    private SpeciesRepository speciesRepository;

    @MockBean
    private StarShipsRepository starShipsRepository;

    @MockBean
    private StarWarsFilmsRepository starWarsFilmsRepository;

    @MockBean
    private VehiclesRepository vehiclesRepository;

    @MockBean
    private RapidMapper rapidMapper;

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
        FilmTo<FilmResultRest> toFilms = new FilmTo<>();
        List<FilmToRest<FilmResultRest>> listFilm = new ArrayList<>();
        FilmToRest films = new FilmToRest();
        films.setResults(new ArrayList());
        listFilm.add(films);
        toFilms.setTo(listFilm);
        filmsRest.setContextWrites(toFilms);

        FilmsRest<PeopleResultRest> peopleRest = new FilmsRest<>();
        FilmTo<PeopleResultRest> toPeople = new FilmTo<>();
        List<FilmToRest<PeopleResultRest>> listPeople = new ArrayList<>();
        FilmToRest people = new FilmToRest();
        people.setResults(new ArrayList());
        listPeople.add(people);
        toPeople.setTo(listPeople);
        peopleRest.setContextWrites(toPeople);

        FilmsRest<PlanetResultRest> planetRest = new FilmsRest<>();
        FilmTo<PlanetResultRest> toPlanet = new FilmTo<>();
        List<FilmToRest<PlanetResultRest>> listPlanet = new ArrayList<>();
        FilmToRest planet = new FilmToRest();
        planet.setResults(new ArrayList());
        listPlanet.add(planet);
        toPlanet.setTo(listPlanet);
        planetRest.setContextWrites(toPlanet);

        FilmsRest<SpeciesResultRest> speciesRest = new FilmsRest<>();
        FilmTo<SpeciesResultRest> toSpecies = new FilmTo<>();
        List<FilmToRest<SpeciesResultRest>> listSpecies = new ArrayList<>();
        FilmToRest species = new FilmToRest();
        species.setResults(new ArrayList());
        listSpecies.add(species);
        toSpecies.setTo(listSpecies);
        speciesRest.setContextWrites(toSpecies);

        FilmsRest<StarShipResultRest> starShipRest = new FilmsRest<>();
        FilmTo<StarShipResultRest> toStarShip = new FilmTo<>();
        List<FilmToRest<StarShipResultRest>> listStarShip = new ArrayList<>();
        FilmToRest starShip = new FilmToRest();
        starShip.setResults(new ArrayList());
        listStarShip.add(starShip);
        toStarShip.setTo(listStarShip);
        starShipRest.setContextWrites(toStarShip);

        FilmsRest<VehicleResultRest> vehicleRest = new FilmsRest<>();
        FilmTo<VehicleResultRest> toVehicle = new FilmTo<>();
        List<FilmToRest<VehicleResultRest>> listVehicle = new ArrayList<>();
        FilmToRest vehicle = new FilmToRest();
        vehicle.setResults(new ArrayList());
        listVehicle.add(vehicle);
        toVehicle.setTo(listVehicle);
        vehicleRest.setContextWrites(toVehicle);

        Mockito.when(rapidRepository.getFilms()).thenReturn(filmsRest);
        Mockito.when(rapidRepository.getPeoples()).thenReturn(peopleRest);
        Mockito.when(rapidRepository.getPlanets()).thenReturn(planetRest);
        Mockito.when(rapidRepository.getSpecies()).thenReturn(speciesRest);
        Mockito.when(rapidRepository.getStarShips()).thenReturn(starShipRest);
        Mockito.when(rapidRepository.getVehicles()).thenReturn(vehicleRest);
        Mockito.when(peoplesRepository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(planetsRepoitory.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(vehiclesRepository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(starShipsRepository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(starWarsFilmsRepository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(speciesRepository.findAll()).thenReturn(new ArrayList<>());
    }

    @Test
    public void shouldGetFilms() {
        //Given
        List<Films> filmsRest = new ArrayList<>();
        //When
        List<Films> result = rapidService.getFilms();
        //Then
        assertEquals(filmsRest,result);
    }

    @Test
    public void shouldGetPeoples() {
        //Given
        List<Peoples> peopleRest = new ArrayList<>();
        //When
        List<Peoples> result = rapidService.getPeoples();
        //Then
        assertEquals(peopleRest,result);
    }

    @Test
    public void shouldGetPlanets() {
        //Given
        List<Planets> planetRest = new ArrayList<>();
        //When
        List<Planets> result = rapidService.getPlanets();
        //Then
        assertEquals(planetRest,result);
    }

    @Test
    public void shouldGetSpecies() {
        //Given
        List<Species> speciesRest = new ArrayList<>();
        //When
        List<Species> result = rapidService.getSpecies();
        //Then
        assertEquals(speciesRest,result);
    }

    @Test
    public void shouldGetStarShips() {
        //Given
        List<StarShips> starShipRest = new ArrayList<>();
        //When
        List<StarShips> result = rapidService.getStarShips();
        //Then
        assertEquals(starShipRest,result);
    }

    @Test
    public void shouldGetVehicles() {
        //Given
        List<Vehicles> vehicleRest = new ArrayList<>();
        //When
        List<Vehicles> result = rapidService.getVehicles();
        //Then
        assertEquals(vehicleRest,result);
    }
}
