package com.project.movie.controller;

import com.google.gson.Gson;
import com.project.movie.domain.jpa.starWars.*;
import com.project.movie.domain.rest.search.CompaniesRest;
import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.domain.rest.starWars.films.FilmsRest;
import com.project.movie.domain.rest.starWars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.domain.rest.starWars.starships.StarShipResultRest;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import com.project.movie.service.RapidService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RapidController.class)
public class RapidControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RapidService rapidService;

    //Done
    @Test
    public void shouldEmptyGetFilms() throws Exception {
        //Given
        List<Films> filmsRest = new ArrayList<>(
        );
        when(rapidService.getFilms()).thenReturn(filmsRest);

        //When & Then
        mockMvc.perform(post("/star-wars/films").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getFilms();
        System.out.println(filmsRest);
    }

    //Done
    @Test
    public void shouldGetFilms() throws Exception {
        //Given
        List<Films> filmsRest = new ArrayList<>();
        filmsRest.add(new Films("a", 1L, "b", "c", "d", "e", 2L));
        when(rapidService.getFilms()).thenReturn(filmsRest);

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

        verify(rapidService, times(1)).getFilms();
        //System.out.println(filmsRest);
    }

    //Done
    @Test
    public void shouldEmptyGetPeoples() throws Exception {
        //Given
        List<Peoples> peopleRest = new ArrayList<>();
        when(rapidService.getPeoples()).thenReturn(peopleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/peoples").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getPeoples();
        System.out.println(peopleRest);
    }

    //Done
    @Test
    public void shouldGetPeoples() throws Exception {
        //Given
        List<Peoples> peopleRest = new ArrayList<>();
        peopleRest.add(new Peoples("a", "b", "c", "d", "e", "f", "g", "h", "i", 1L));
        when(rapidService.getPeoples()).thenReturn(peopleRest);

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
        verify(rapidService, times(1)).getPeoples();
        System.out.println(peopleRest);
    }

    //Done
    @Test
    public void shouldEmptyGetPlanets() throws Exception {
        //Given
        List<Planets> planetRest = new ArrayList<>(
        );
        when(rapidService.getPlanets()).thenReturn(planetRest);

        //When & Then
        mockMvc.perform(post("/star-wars/planets").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getPlanets();
        System.out.println(planetRest);
    }

    //Done
    @Test
    public void shouldGetPlanets() throws Exception {
        //Given
        List<Planets> planetRest = new ArrayList<>();
        planetRest.add(new Planets("a", "b", "c", "d", "e", "f", "g", 1L));
        when(rapidService.getPlanets()).thenReturn(planetRest);

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
        verify(rapidService, times(1)).getPlanets();
        System.out.println(planetRest);
    }

    //Done
    @Test
    public void shouldEmptyGetSpecies() throws Exception {
        //Given
        List<Species> speciesRest = new ArrayList<>(
        );
        when(rapidService.getSpecies()).thenReturn(speciesRest);

        //When & Then
        mockMvc.perform(post("/star-wars/species").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getSpecies();
        System.out.println(speciesRest);
    }

    //Done
    @Test
    public void shouldGetSpecies() throws Exception {
        //Given
        List<Species> speciesRest = new ArrayList<>();
        speciesRest.add(new Species("a", "b", "c", "d", "e", "f", "g", "h", 1L));
        when(rapidService.getSpecies()).thenReturn(speciesRest);

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
        verify(rapidService, times(1)).getSpecies();
        System.out.println(speciesRest);
    }

    //Done
    @Test
    public void shouldEmptyGetStarShips() throws Exception {
        //Given
        List<StarShips> starShipRest = new ArrayList<>(
        );
        when(rapidService.getStarShips()).thenReturn(starShipRest);

        //When & Then
        mockMvc.perform(post("/star-wars/star-ships").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getStarShips();
        System.out.println(starShipRest);
    }

    //Done
    @Test
    public void shouldGetStarShips() throws Exception {
        //Given
        List<StarShips> starShipRest = new ArrayList<>();
        starShipRest.add(new StarShips("a", "b", "c", "d", "e", "f", "g", "h", 1L));
        when(rapidService.getStarShips()).thenReturn(starShipRest);

        //When & Then
        mockMvc.perform(post("/star-wars/star-ships").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[0].model", is("b")))
                .andExpect(jsonPath("$[0].manufacturer", is("c")))
                .andExpect(jsonPath("$[0].crew", is("d")))
                .andExpect(jsonPath("$[0].passengers", is("e")))
                .andExpect(jsonPath("$[0].cargo_capacity", is("f")))
                .andExpect(jsonPath("$[0].starship_class", is("g")))
                .andExpect(jsonPath("$[0].url", is("h")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getStarShips();
        System.out.println(starShipRest);
    }

    //Done
    @Test
    public void shouldEmptyGetVehicles() throws Exception {
        //Given
        List<Vehicles> vehicleRest = new ArrayList<>(
        );
        when(rapidService.getVehicles()).thenReturn(vehicleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/vehicles").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getVehicles();
        System.out.println(vehicleRest);
    }


    //Done
    @Test
    public void shouldGetVehicles() throws Exception {
        //Given
        List<Vehicles> vehicleRest = new ArrayList<>();
        vehicleRest.add(new Vehicles("a", "b", "c", "d", "e", "f", "g", 1L));
        when(rapidService.getVehicles()).thenReturn(vehicleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/vehicles").content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("a")))
                .andExpect(jsonPath("$[0].model", is("b")))
                .andExpect(jsonPath("$[0].length", is("c")))
                .andExpect(jsonPath("$[0].crew", is("d")))
                .andExpect(jsonPath("$[0].passengers", is("e")))
                .andExpect(jsonPath("$[0].vehicle_class", is("f")))
                .andExpect(jsonPath("$[0].url", is("g")))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getVehicles();
        System.out.println(vehicleRest);
    }
}