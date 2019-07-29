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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RapidController.class)
public class RapidControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RapidService rapidService;

    @Test
    public void shouldEmptyGetFilms() throws Exception {
        //Given
        List<Films> filmsRest = new ArrayList<>(
        );
        when(rapidService.getFilms()).thenReturn(filmsRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(filmsRest);

        //When & Then
        mockMvc.perform(post("/star-wars/films").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getFilms();
        System.out.println(filmsRest);
    }

    @Test
    public void shouldGetFilms() throws Exception {
        //Given
        List<Films> filmsRest = new ArrayList<>(
        );
        when(rapidService.getFilms()).thenReturn(filmsRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(filmsRest);

        //When & Then
        mockMvc.perform(post("/star-wars/films").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getFilms();
        System.out.println(filmsRest);
    }

    @Test
    public void shouldEmptyGetPeoples() throws Exception {
        //Given
        List<Peoples> peopleRest = new ArrayList<>(
        );
        when(rapidService.getPeoples()).thenReturn(peopleRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(peopleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/peoples").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getPeoples();
        System.out.println(peopleRest);
    }

    @Test
    public void shouldGetPeoples() throws Exception {
        //Given
        List<Peoples> peopleRest = new ArrayList<>(
        );
        when(rapidService.getPeoples()).thenReturn(peopleRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(peopleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/peoples").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getPeoples();
        System.out.println(peopleRest);
    }

    @Test
    public void shouldEmptyGetPlanets() throws Exception {
        //Given
        List<Planets> planetRest = new ArrayList<>(
        );
        when(rapidService.getPlanets()).thenReturn(planetRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(planetRest);

        //When & Then
        mockMvc.perform(post("/star-wars/planets").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getPlanets();
        System.out.println(planetRest);
    }

    @Test
    public void shouldGetPlanets() throws Exception {
        //Given
        List<Planets> planetRest = new ArrayList<>(
        );
        when(rapidService.getPlanets()).thenReturn(planetRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(planetRest);

        //When & Then
        mockMvc.perform(post("/star-wars/planets").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getPlanets();
        System.out.println(planetRest);
    }

    @Test
    public void shouldEmptyGetSpecies() throws Exception {
        //Given
        List<Species> speciesRest = new ArrayList<>(
        );
        when(rapidService.getSpecies()).thenReturn(speciesRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(speciesRest);

        //When & Then
        mockMvc.perform(post("/star-wars/species").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getSpecies();
        System.out.println(speciesRest);
    }

    @Test
    public void shouldGetSpecies() throws Exception {
        //Given
        List<Species> speciesRest = new ArrayList<>(
        );
        when(rapidService.getSpecies()).thenReturn(speciesRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(speciesRest);

        //When & Then
        mockMvc.perform(post("/star-wars/species").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getSpecies();
        System.out.println(speciesRest);
    }

    @Test
    public void shouldEmptyGetStarShips() throws Exception {
        //Given
        List<StarShips> starShipRest = new ArrayList<>(
        );
        when(rapidService.getStarShips()).thenReturn(starShipRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(starShipRest);

        //When & Then
        mockMvc.perform(post("/star-wars/star-ships").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getStarShips();
        System.out.println(starShipRest);
    }

    @Test
    public void shouldGetStarShips() throws Exception {
        //Given
        List<StarShips> starShipRest = new ArrayList<>(
        );
        when(rapidService.getStarShips()).thenReturn(starShipRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(starShipRest);

        //When & Then
        mockMvc.perform(post("/star-wars/star-ships").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getStarShips();
        System.out.println(starShipRest);
    }

    @Test
    public void shouldEmptyGetVehicles() throws Exception {
        //Given
        List<Vehicles> vehicleRest = new ArrayList<>(
        );
        when(rapidService.getVehicles()).thenReturn(vehicleRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(vehicleRest);

        //When & Then
        mockMvc.perform(post("/star-wars/vehicles").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(rapidService, times(1)).getVehicles();
        System.out.println(vehicleRest);
    }

    @Test
    public void shouldGetVehicles() throws Exception {
        //Given
        List<Vehicles> vehicleRest = new ArrayList<>();
        vehicleRest.add(new Vehicles());
        //FilmsRest<VehicleResultRest> vehicleRest = new FilmsRest<>();
        //when(rapidService.getVehicles()).thenReturn(vehicleRest);

//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(vehicleRest);
//
//        //When & Then
//        mockMvc.perform(post("/star-wars/vehicles").content(String.valueOf(MediaType.APPLICATION_JSON))
//                .characterEncoding("UTF-8")
//                .content(jsonContent))
//                .andExpect(status().isOk());
//        verify(rapidService, times(1)).getVehicles();
//        System.out.println(vehicleRest);
    }
}