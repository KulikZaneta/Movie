package com.project.movie.controller;

import com.project.movie.domain.jpa.star.wars.*;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsFactoryStrategy;
import com.project.movie.strategy.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RapidController.class)
public class RapidControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StarWarsFactoryStrategy starWarsFactoryStrategy;

    @MockBean
    private FilmsService filmsService;

    @MockBean
    private PeoplesService peoplesService;

    @MockBean
    private SpeciesService speciesService;

    @MockBean
    private StarShipsService starShipsService;

    @MockBean
    private VehicleService vehicleService;

    @MockBean
    private PlanetsService planetsService;



    @Test
    public void shouldEmptyGetFilms() throws Exception {
        //Given
        List<Films> filmsRest = new ArrayList<>();
        when(starWarsFactoryStrategy.getByEnum(StarWars.FILMS)).thenReturn(filmsService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.FILMS).get()).thenReturn(filmsRest);

        //When & Then
        mockMvc.perform(post("/star-wars/films").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.FILMS);
    }

    @Test
    public void shouldGetFilms() throws Exception {
        //Given
        List<Films> filmsRest = new ArrayList<>();
        filmsRest.add(new Films("a", 1L, "b", "c", "d", "e", 2L));
        when(starWarsFactoryStrategy.getByEnum(StarWars.FILMS)).thenReturn(filmsService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.FILMS).get()).thenReturn(filmsRest);

        //When & Then
        mockMvc.perform(post("/star-wars/films").content(String.valueOf(MediaType.APPLICATION_JSON)))
                //.characterEncoding("UTF-8")
                //.content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("a")))
                .andExpect(jsonPath("$[0].episodeId", is(1)))
                .andExpect(jsonPath("$[0].director", is("b")))
                .andExpect(jsonPath("$[0].producer", is("c")))
                .andExpect(jsonPath("$[0].releaseDate", is("d")))
                .andExpect(jsonPath("$[0].url", is("e")))
                .andExpect(jsonPath("$[0].id", is(2)));

        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.FILMS);
    }

    @Test
    public void shouldEmptyGetPeoples() throws Exception {
        //Given
        List<Peoples> peopleRest = new ArrayList<>();
        when(starWarsFactoryStrategy.getByEnum(StarWars.PEOPLES)).thenReturn(peoplesService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.PEOPLES).get()).thenReturn(peopleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/peoples").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.PEOPLES);
    }

    @Test
    public void shouldGetPeoples() throws Exception {
        //Given
        List<Peoples> peopleRest = new ArrayList<>();
        when(starWarsFactoryStrategy.getByEnum(StarWars.PEOPLES)).thenReturn(peoplesService);
        peopleRest.add(new Peoples("a", "b", "c", "d", "e", "f", "g", "h", "i", 1L));
        when(starWarsFactoryStrategy.getByEnum(StarWars.PEOPLES).get()).thenReturn(peopleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/peoples").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[0].height", is("b")))
                .andExpect(jsonPath("$[0].hairColor", is("c")))
                .andExpect(jsonPath("$[0].skinColor", is("d")))
                .andExpect(jsonPath("$[0].eyeColor", is("e")))
                .andExpect(jsonPath("$[0].birthYear", is("f")))
                .andExpect(jsonPath("$[0].gender", is("g")))
                .andExpect(jsonPath("$[0].homeworld", is("h")))
                .andExpect(jsonPath("$[0].url", is("i")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.PEOPLES);
    }

    @Test
    public void shouldEmptyGetPlanets() throws Exception {
        //Given
        List<Planets> planetRest = new ArrayList<>();
        when(starWarsFactoryStrategy.getByEnum(StarWars.PLANETS)).thenReturn(planetsService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.PLANETS).get()).thenReturn(planetRest);

        //When & Then
        mockMvc.perform(post("/star-wars/planets").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.PLANETS);
    }

    @Test
    public void shouldGetPlanets() throws Exception {
        //Given
        List<Planets> planetRest = new ArrayList<>();
        planetRest.add(new Planets("a", "b", "c", "d", "e", "f", "g", 1L));
        when(starWarsFactoryStrategy.getByEnum(StarWars.PLANETS)).thenReturn(planetsService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.PLANETS).get()).thenReturn(planetRest);

        //When & Then
        mockMvc.perform(post("/star-wars/planets").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[0].climate", is("b")))
                .andExpect(jsonPath("$[0].gravity", is("c")))
                .andExpect(jsonPath("$[0].terrain", is("d")))
                .andExpect(jsonPath("$[0].surfaceWater", is("e")))
                .andExpect(jsonPath("$[0].population", is("f")))
                .andExpect(jsonPath("$[0].url", is("g")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.PLANETS);
    }

    @Test
    public void shouldEmptyGetSpecies() throws Exception {
        //Given
        List<Species> speciesRest = new ArrayList<>();
        when(starWarsFactoryStrategy.getByEnum(StarWars.SPECIES)).thenReturn(speciesService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.SPECIES).get()).thenReturn(speciesRest);

        //When & Then
        mockMvc.perform(post("/star-wars/species").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.SPECIES);
    }


    @Test
    public void shouldGetSpecies() throws Exception {
        //Given
        List<Species> speciesRest = new ArrayList<>();
        speciesRest.add(new Species("a", "b", "c", "d", "e", "f", "g", "h", 1L));
        when(starWarsFactoryStrategy.getByEnum(StarWars.SPECIES)).thenReturn(speciesService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.SPECIES).get()).thenReturn(speciesRest);

        //When & Then
        mockMvc.perform(post("/star-wars/species").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[0].averageHeight", is("b")))
                .andExpect(jsonPath("$[0].skinColors", is("c")))
                .andExpect(jsonPath("$[0].hairColors", is("d")))
                .andExpect(jsonPath("$[0].eyeColors", is("e")))
                .andExpect(jsonPath("$[0].homeworld", is("f")))
                .andExpect(jsonPath("$[0].language", is("g")))
                .andExpect(jsonPath("$[0].url", is("h")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.SPECIES);
    }

    @Test
    public void shouldEmptyGetStarShips() throws Exception {
        //Given
        List<StarShips> starShipRest = new ArrayList<>();
        when(starWarsFactoryStrategy.getByEnum(StarWars.STARSHIPS)).thenReturn(starShipsService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.STARSHIPS).get()).thenReturn(starShipRest);

        //When & Then
        mockMvc.perform(post("/star-wars/star-ships").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.STARSHIPS);
    }

    @Test
    public void shouldGetStarShips() throws Exception {
        //Given
        List<StarShips> starShipRest = new ArrayList<>();
        starShipRest.add(new StarShips("a", "b", "c", "d", "e", "f", "g", "h", 1L));
        when(starWarsFactoryStrategy.getByEnum(StarWars.STARSHIPS)).thenReturn(starShipsService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.STARSHIPS).get()).thenReturn(starShipRest);

        //When & Then
        mockMvc.perform(post("/star-wars/star-ships").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[0].model", is("b")))
                .andExpect(jsonPath("$[0].manufacturer", is("c")))
                .andExpect(jsonPath("$[0].crew", is("d")))
                .andExpect(jsonPath("$[0].passengers", is("e")))
                .andExpect(jsonPath("$[0].cargoCapacity", is("f")))
                .andExpect(jsonPath("$[0].starshipClass", is("g")))
                .andExpect(jsonPath("$[0].url", is("h")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.STARSHIPS);
    }

    @Test
    public void shouldEmptyGetVehicles() throws Exception {
        //Given
        List<Vehicles> vehicleRest = new ArrayList<>();
        when(starWarsFactoryStrategy.getByEnum(StarWars.VEHICLES)).thenReturn(vehicleService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.VEHICLES).get()).thenReturn(vehicleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/vehicles").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.VEHICLES);
    }

    @Test
    public void shouldGetVehicles() throws Exception {
        //Given
        List<Vehicles> vehicleRest = new ArrayList<>();
        vehicleRest.add(new Vehicles("a", "b", "c", "d", "e", "f", "g", 1L));
        when(starWarsFactoryStrategy.getByEnum(StarWars.VEHICLES)).thenReturn(vehicleService);
        when(starWarsFactoryStrategy.getByEnum(StarWars.VEHICLES).get()).thenReturn(vehicleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/vehicles").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[0].model", is("b")))
                .andExpect(jsonPath("$[0].length", is("c")))
                .andExpect(jsonPath("$[0].crew", is("d")))
                .andExpect(jsonPath("$[0].passengers", is("e")))
                .andExpect(jsonPath("$[0].vehicleClass", is("f")))
                .andExpect(jsonPath("$[0].url", is("g")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(status().isOk());
        verify(starWarsFactoryStrategy, times(2)).getByEnum(StarWars.VEHICLES);
    }
}