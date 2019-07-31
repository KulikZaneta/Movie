package com.project.movie.controller;

import com.google.gson.Gson;
import com.project.movie.domain.rest.authentication.GuestSessionRest;
import com.project.movie.domain.rest.authentication.TokenRest;
import com.project.movie.service.AuthenticationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationService authenticationService;

    //Done
    @Test
    public void shouldGetCreateToken() throws Exception {
        //Given
        GuestSessionRest guestSessionRest = new GuestSessionRest(
                true,
                "368d6f98fcea43d6e9c6abd752be388f",
                "2019-07-30 10:29:28 UTC"
        );
        when(authenticationService.createSession()).thenReturn(guestSessionRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(guestSessionRest);

        //When & Then
        mockMvc.perform(get("/auth/guest").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(authenticationService, times(1)).createSession();
    }

    //Done
    @Test
    public void shouldGetSession() throws Exception {
        //Given
        TokenRest tokenRest = new TokenRest(
                true,
                "2019-07-29 11:44:15 UTC",
                "d18f375cdbe40628ba3fde7f0bf284b2bc58bb53"
        );
        when(authenticationService.createToken()).thenReturn(tokenRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(tokenRest);

        //When & Then
        mockMvc.perform(get("/auth/token").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(authenticationService, times(1)).createToken();
    }
}