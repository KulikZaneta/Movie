package com.project.movie.service;

import com.project.movie.domain.rest.authentication.GuestSessionRest;
import com.project.movie.domain.rest.authentication.TokenRest;
import com.project.movie.repository.rest.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationRepository authenticationRepository;

    public TokenRest createToken() {
        return authenticationRepository.getToken();
    }

    public GuestSessionRest createSession() {
        return authenticationRepository.getGuestSession();
    }
}
