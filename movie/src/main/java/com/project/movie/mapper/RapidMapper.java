package com.project.movie.mapper;

import com.project.movie.domain.jpa.star.wars.*;
import com.project.movie.domain.rest.star.wars.films.FilmResultRest;
import com.project.movie.domain.rest.star.wars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.star.wars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.star.wars.species.SpeciesResultRest;
import com.project.movie.domain.rest.star.wars.starships.StarShipResultRest;
import com.project.movie.domain.rest.star.wars.vehicles.VehicleResultRest;
import org.springframework.stereotype.Component;

@Component
public class RapidMapper {
    public Films mapToFilm(FilmResultRest filmResultRest) {
        return Films.builder()
                .director(filmResultRest.getDirector())
                .episodeId(filmResultRest.getEpisodeId())
                .producer(filmResultRest.getProducer())
                .releaseDate(filmResultRest.getReleaseDate())
                .title(filmResultRest.getTitle())
                .url(filmResultRest.getUrl())
                .build();
    }

    public Peoples mapToPeople(PeopleResultRest peopleResultRest) {
        return Peoples.builder()
                .birthYear(peopleResultRest.getBirthYear())
                .eyeColor(peopleResultRest.getEyeColor())
                .gender(peopleResultRest.getGender())
                .hairColor(peopleResultRest.getHairColor())
                .height(peopleResultRest.getHeight())
                .homeworld(peopleResultRest.getHomeworld())
                .name(peopleResultRest.getName())
                .skinColor(peopleResultRest.getSkinColor())
                .url(peopleResultRest.getUrl())
                .build();
    }

    public Species mapToSpecies(SpeciesResultRest speciesResultRest) {
        return Species.builder()
                .averageHeight(speciesResultRest.getAverageHeight())
                .eyeColors(speciesResultRest.getEyeColors())
                .hairColors(speciesResultRest.getHairColors())
                .homeworld(speciesResultRest.getHomeworld())
                .language(speciesResultRest.getLanguage())
                .name(speciesResultRest.getName())
                .skinColors(speciesResultRest.getSkinColors())
                .url(speciesResultRest.getUrl())
                .build();
    }

    public Planets mapToPlanets(PlanetResultRest planetResultRest) {
        return Planets.builder()
                .climate(planetResultRest.getClimate())
                .gravity(planetResultRest.getGravity())
                .name(planetResultRest.getName())
                .population(planetResultRest.getPopulation())
                .surfaceWater(planetResultRest.getSurfaceWater())
                .terrain(planetResultRest.getTerrain())
                .url(planetResultRest.getUrl())
                .build();
    }

    public StarShips mapToStarShips(StarShipResultRest starShipResultRest) {
        return StarShips.builder()
                .cargoCapacity(starShipResultRest.getCargoCapacity())
                .crew(starShipResultRest.getCrew())
                .manufacturer(starShipResultRest.getManufacturer())
                .model(starShipResultRest.getModel())
                .passengers(starShipResultRest.getPassengers())
                .name(starShipResultRest.getName())
                .starshipClass(starShipResultRest.getStarshipClass())
                .url(starShipResultRest.getUrl())
                .build();
    }

    public Vehicles mapToVehicles(VehicleResultRest vehicleResultRest) {
        return Vehicles.builder()
                .crew(vehicleResultRest.getCrew())
                .length(vehicleResultRest.getLength())
                .model(vehicleResultRest.getModel())
                .name(vehicleResultRest.getName())
                .passengers(vehicleResultRest.getPassengers())
                .vehicleClass(vehicleResultRest.getVehicleClass())
                .url(vehicleResultRest.getUrl())
                .build();
    }
}
