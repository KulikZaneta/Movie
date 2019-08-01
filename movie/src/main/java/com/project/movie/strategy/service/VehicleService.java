package com.project.movie.strategy.service;

import com.project.movie.domain.jpa.starWars.Vehicles;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import com.project.movie.mapper.RapidMapper;
import com.project.movie.repository.jpa.starWars.VehiclesRepository;
import com.project.movie.repository.rest.RapidRepository;
import com.project.movie.strategy.StarWars;
import com.project.movie.strategy.StarWarsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService extends StarWarsStrategy {
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
    public Object get() {
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
