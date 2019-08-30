package com.project.movie.service;

import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.star.wars.*;
import com.project.movie.repository.rest.RapidRepository;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public abstract class RapidServiceTest<T>  {
    @Mock
    protected RapidRepository rapidRepository;

    @Mock
    protected PeoplesRepository peoplesRepository;

    @Mock
    protected PlanetsRepoitory planetsRepoitory;

    @Mock
    protected SpeciesRepository speciesRepository;

    @Mock
    protected StarShipsRepository starShipsRepository;

    @Mock
    protected StarWarsFilmsRepository starWarsFilmsRepository;

    @Mock
    protected VehiclesRepository vehiclesRepository;

    @Mock
    protected RapidMapper rapidMapper;

    public abstract List<T> getResult();

    @Test
    public void shouldGetListStarWarsStrategy() {
        //Given
        List<T> filmsRest = new ArrayList<>();
        //When
        List<T> result = getResult();
        //Then
        assertEquals(filmsRest,result);
    }
}
