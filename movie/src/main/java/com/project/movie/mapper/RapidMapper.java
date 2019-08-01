package com.project.movie.mapper;

import com.project.movie.domain.jpa.starWars.*;
import com.project.movie.domain.rest.starWars.films.FilmResultRest;
import com.project.movie.domain.rest.starWars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.starWars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.starWars.species.SpeciesResultRest;
import com.project.movie.domain.rest.starWars.starships.StarShipResultRest;
import com.project.movie.domain.rest.starWars.vehicles.VehicleResultRest;
import org.springframework.stereotype.Component;

@Component
public class RapidMapper {
    public Films mapToFilm(FilmResultRest filmResultRest) {
        return Films.builder()
                .director(filmResultRest.getDirector())
                .episodeId(filmResultRest.getEpisode_id())
                .producer(filmResultRest.getProducer())
                .releaseDate(filmResultRest.getRelease_date())
                .title(filmResultRest.getTitle())
                .url(filmResultRest.getUrl())
                .build();
    }

    public Peoples mapToPeople(PeopleResultRest peopleResultRest) {
        return Peoples.builder()
                .birthYear(peopleResultRest.getBirth_year())
                .eyeColor(peopleResultRest.getEye_color())
                .gender(peopleResultRest.getGender())
                .hairColor(peopleResultRest.getHair_color())
                .height(peopleResultRest.getHeight())
                .homeworld(peopleResultRest.getHomeworld())
                .name(peopleResultRest.getName())
                .skinColor(peopleResultRest.getSkin_color())
                .url(peopleResultRest.getUrl())
                .build();
    }

    public Species mapToSpecies(SpeciesResultRest speciesResultRest) {
        return Species.builder()
                .averageHeight(speciesResultRest.getAverage_height())
                .eyeColors(speciesResultRest.getEye_colors())
                .hairColors(speciesResultRest.getHair_colors())
                .homeworld(speciesResultRest.getHomeworld())
                .language(speciesResultRest.getLanguage())
                .name(speciesResultRest.getName())
                .skinColors(speciesResultRest.getSkin_colors())
                .url(speciesResultRest.getUrl())
                .build();
    }

    public Planets mapToPlanets(PlanetResultRest planetResultRest) {
        return Planets.builder()
                .climate(planetResultRest.getClimate())
                .gravity(planetResultRest.getGravity())
                .name(planetResultRest.getName())
                .population(planetResultRest.getPopulation())
                .surfaceWater(planetResultRest.getSurface_water())
                .terrain(planetResultRest.getTerrain())
                .url(planetResultRest.getUrl())
                .build();
    }

    public StarShips mapToStarShips(StarShipResultRest starShipResultRest) {
        return StarShips.builder()
                .cargo_capacity(starShipResultRest.getCargo_capacity())
                .crew(starShipResultRest.getCrew())
                .manufacturer(starShipResultRest.getManufacturer())
                .model(starShipResultRest.getModel())
                .passengers(starShipResultRest.getPassengers())
                .name(starShipResultRest.getName())
                .starship_class(starShipResultRest.getStarship_class())
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
                .vehicle_class(vehicleResultRest.getVehicle_class())
                .url(vehicleResultRest.getUrl())
                .build();
    }
}
