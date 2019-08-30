package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.star.wars.Peoples;
import com.project.movie.domain.rest.star.wars.peoples.PeopleResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.star.wars.PeoplesRepository;
import com.project.movie.repository.rest.RapidRepository;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsStrategy;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EqualsAndHashCode
public class PeoplesService extends StarWarsStrategy<Peoples> {
    @Autowired
    private RapidRepository rapidRepository;

    @Autowired
    private PeoplesRepository peoplesRepository;

    @Autowired
    private RapidMapper rapidMapper;

    protected PeoplesService() {
        super(StarWars.PEOPLES);
    }

    @Override
    public List<Peoples> get() {
        List<PeopleResultRest> peopleRest = rapidRepository.getPeoples().getContextWrites().getTo().get(0).getResults();
        List<Peoples> findPeoples = peoplesRepository.findAll();
        if (peopleRest.size() == findPeoples.size()) {
            return findPeoples;
        }
        return peoplesRepository.saveAll(peopleRest.stream()
                .map(rapidMapper::mapToPeople)
                .collect(Collectors.toList()));
    }
}
