package com.project.movie.service.strategy;

import com.project.movie.domain.jpa.star.wars.Vehicles;
import com.project.movie.domain.rest.star.wars.films.FilmTo;
import com.project.movie.domain.rest.star.wars.films.FilmToRest;
import com.project.movie.domain.rest.star.wars.films.FilmsRest;
import com.project.movie.domain.rest.star.wars.vehicles.VehicleResultRest;
import com.project.movie.service.RapidServiceTest;
import com.project.movie.strategy.service.VehicleService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class VehiclesServiceTest extends RapidServiceTest<Vehicles> {
    @InjectMocks
    private VehicleService vehicleService;

    @Before
    public void setUp() {
        FilmsRest<VehicleResultRest> vehicleRest = new FilmsRest<>();
        FilmTo<VehicleResultRest> toVehicle = new FilmTo<>();
        List<FilmToRest<VehicleResultRest>> listVehicle = new ArrayList<>();
        FilmToRest vehicle = new FilmToRest();
        vehicle.setResults(new ArrayList());
        listVehicle.add(vehicle);
        toVehicle.setTo(listVehicle);
        vehicleRest.setContextWrites(toVehicle);

        Mockito.when(rapidRepository.getVehicles()).thenReturn(vehicleRest);
        Mockito.when(vehiclesRepository.findAll()).thenReturn(new ArrayList<>());
    }

    @Override
    public List<Vehicles> getResult() {
        return vehicleService.get();
    }
}
