package com.project.movie.controller;

import com.project.movie.domain.rest.authentication.GuestSessionRest;
import com.project.movie.domain.rest.authentication.TokenRest;
import com.project.movie.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/token")
    public TokenRest getCreateToken() {
        return authenticationService.createToken();
    }

    @GetMapping("/guest")
    public GuestSessionRest getSession() {
        return authenticationService.createSession();
    }
}
