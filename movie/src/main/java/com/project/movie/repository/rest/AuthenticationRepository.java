package com.project.movie.repository.rest;

import com.project.movie.domain.rest.authentication.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;



@Repository
@Slf4j
public class AuthenticationRepository {
    @Value("${url.movieDb}")
    private String movieDb;

    @Value("${movie.api.key}")
    private String apiKey;


    public TokenRest getToken() {
        return new RestTemplate().getForObject(movieDb.concat("/authentication/token/new?" + apiKey),TokenRest.class);
    }

    public GuestSessionRest getGuestSession() {
        return new RestTemplate().getForObject(movieDb.concat("/authentication/session/new?" + apiKey), GuestSessionRest.class);
    }
}
