package com.project.movie.service.strategy;


import com.project.movie.domain.jpa.star.wars.Peoples;
import com.project.movie.domain.rest.star.wars.films.FilmTo;
import com.project.movie.domain.rest.star.wars.films.FilmToRest;
import com.project.movie.domain.rest.star.wars.films.FilmsRest;
import com.project.movie.domain.rest.star.wars.peoples.PeopleResultRest;
import com.project.movie.service.RapidServiceTest;
import com.project.movie.strategy.service.PeoplesService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PeopleServiceTest extends RapidServiceTest<Peoples> {

    @InjectMocks
    private PeoplesService peoplesService;

    @Before
    public void setUp() {

        FilmsRest<PeopleResultRest> peopleRest = new FilmsRest<>();
        FilmTo<PeopleResultRest> toPeople = new FilmTo<>();
        List<FilmToRest<PeopleResultRest>> listPeople = new ArrayList<>();
        FilmToRest people = new FilmToRest();
        people.setResults(new ArrayList());
        listPeople.add(people);
        toPeople.setTo(listPeople);
        peopleRest.setContextWrites(toPeople);

        Mockito.when(rapidRepository.getPeoples()).thenReturn(peopleRest);
        Mockito.when(peoplesRepository.findAll()).thenReturn(new ArrayList<>());
    }

    @Override
    public List<Peoples> getResult() {
        return peoplesService.get();
    }
}
