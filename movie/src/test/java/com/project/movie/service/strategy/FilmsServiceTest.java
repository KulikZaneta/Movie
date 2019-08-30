package com.project.movie.service.strategy;

import com.project.movie.domain.jpa.star.wars.Films;
import com.project.movie.domain.rest.star.wars.films.FilmResultRest;
import com.project.movie.domain.rest.star.wars.films.FilmTo;
import com.project.movie.domain.rest.star.wars.films.FilmToRest;
import com.project.movie.domain.rest.star.wars.films.FilmsRest;
import com.project.movie.service.RapidServiceTest;
import com.project.movie.strategy.service.FilmsService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class FilmsServiceTest extends RapidServiceTest<Films> {
    @InjectMocks
    public FilmsService filmsService;

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

        Mockito.when(rapidRepository.getFilms()).thenReturn(filmsRest);
    }

    @Override
    public List<Films> getResult() {
        return filmsService.get();
    }
}