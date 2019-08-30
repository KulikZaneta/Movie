package com.project.movie.service.strategy;

import com.project.movie.domain.jpa.star.wars.Species;
import com.project.movie.domain.rest.star.wars.films.FilmTo;
import com.project.movie.domain.rest.star.wars.films.FilmToRest;
import com.project.movie.domain.rest.star.wars.films.FilmsRest;
import com.project.movie.domain.rest.star.wars.species.SpeciesResultRest;
import com.project.movie.service.RapidServiceTest;
import com.project.movie.strategy.service.SpeciesService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SpeciesServiceTest extends RapidServiceTest<Species> {
    @InjectMocks
    private SpeciesService speciesService;

    @Before
    public void setUp() {
        FilmsRest<SpeciesResultRest> speciesRest = new FilmsRest<>();
        FilmTo<SpeciesResultRest> toSpecies = new FilmTo<>();
        List<FilmToRest<SpeciesResultRest>> listSpecies = new ArrayList<>();
        FilmToRest species = new FilmToRest();
        species.setResults(new ArrayList());
        listSpecies.add(species);
        toSpecies.setTo(listSpecies);
        speciesRest.setContextWrites(toSpecies);

        Mockito.when(rapidRepository.getSpecies()).thenReturn(speciesRest);
        Mockito.when(speciesRepository.findAll()).thenReturn(new ArrayList<>());

    }

    @Override
    public List<Species> getResult() {
        return speciesService.get();
    }
}
