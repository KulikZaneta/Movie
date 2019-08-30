package com.project.movie.repository.rest;

import com.project.movie.domain.rest.star.wars.films.FilmResultRest;
import com.project.movie.domain.rest.star.wars.films.FilmsRest;
import com.project.movie.domain.rest.star.wars.peoples.PeopleResultRest;
import com.project.movie.domain.rest.star.wars.plantes.PlanetResultRest;
import com.project.movie.domain.rest.star.wars.species.SpeciesResultRest;
import com.project.movie.domain.rest.star.wars.starships.StarShipResultRest;
import com.project.movie.domain.rest.star.wars.vehicles.VehicleResultRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class RapidRepository {
    @Value("${api.key.rapid}")
    private String apiKeyRapid;

    @Value("${url.rapidapi}")
    private String urlRapidApi;

    private static final String RAPID_KEY = "X-RapidAPI-Key";

    public FilmsRest<FilmResultRest> getFilms() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RAPID_KEY, apiKeyRapid);
        HttpEntity httpEntity = new HttpEntity("", httpHeaders);
        return new RestTemplate().exchange(urlRapidApi + "getFilms", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<FilmsRest<FilmResultRest>>() {}).getBody();
    }

    public FilmsRest<PeopleResultRest> getPeoples() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RAPID_KEY, apiKeyRapid);
        HttpEntity httpEntity = new HttpEntity("", httpHeaders);
        return new RestTemplate().exchange(urlRapidApi + "getPeoples", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<FilmsRest<PeopleResultRest>>() {}).getBody();
    }

    public FilmsRest<PlanetResultRest> getPlanets() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RAPID_KEY, apiKeyRapid);
        HttpEntity httpEntity = new HttpEntity("", httpHeaders);
        return new RestTemplate().exchange(urlRapidApi + "getPlanets", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<FilmsRest<PlanetResultRest>>() {}).getBody();
    }

    public FilmsRest<SpeciesResultRest> getSpecies() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RAPID_KEY, apiKeyRapid);
        HttpEntity httpEntity = new HttpEntity("", httpHeaders);
        return new RestTemplate().exchange(urlRapidApi + "getSpecies", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<FilmsRest<SpeciesResultRest>>() {}).getBody();
    }

    public FilmsRest<StarShipResultRest> getStarShips() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RAPID_KEY, apiKeyRapid);
        HttpEntity httpEntity = new HttpEntity("", httpHeaders);
        return new RestTemplate().exchange(urlRapidApi + "getStarships", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<FilmsRest<StarShipResultRest>>() {}).getBody();
    }

    public FilmsRest<VehicleResultRest> getVehicles() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RAPID_KEY, apiKeyRapid);
        HttpEntity httpEntity = new HttpEntity("", httpHeaders);
        return new RestTemplate().exchange(urlRapidApi + "getVehicles", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<FilmsRest<VehicleResultRest>>() {}).getBody();
    }
}
