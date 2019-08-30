package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.star.wars.Vehicles;
import com.project.movie.domain.rest.star.wars.vehicles.VehicleResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.star.wars.VehiclesRepository;
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
public class VehicleService extends StarWarsStrategy<Vehicles> {
    @Autowired
    private RapidRepository rapidRepository;

    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Autowired
    private RapidMapper rapidMapper;

    protected VehicleService() {
        super(StarWars.VEHICLES);
    }

    @Override
    public List<Vehicles> get() {
        List<VehicleResultRest> vehiclesRest = rapidRepository.getVehicles().getContextWrites().getTo().get(0).getResults();
        List<Vehicles> findVehicles = vehiclesRepository.findAll();
        if (vehiclesRest.size() == findVehicles.size()) {
            return findVehicles;
        }
        return vehiclesRepository.saveAll(vehiclesRest.stream()
                .map(rapidMapper::mapToVehicles)
                .collect(Collectors.toList()));
    }
}
