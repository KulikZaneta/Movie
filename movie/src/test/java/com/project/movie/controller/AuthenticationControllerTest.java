package com.project.movie.controller;

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

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationService authenticationService;

    @Test
    public void shouldGetCreateToken() throws Exception {
        //Given
        GuestSessionRest guestSessionRest = new GuestSessionRest(
                true,
                "368d6f98fcea43d6e9c6abd752be388f",
                "2019-07-30 10:29:28 UTC"
        );
        when(authenticationService.createSession()).thenReturn(guestSessionRest);

        //When & Then
        mockMvc.perform(get("/auth/guest").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.guest_session_id", is("368d6f98fcea43d6e9c6abd752be388f")))
                .andExpect(jsonPath("$.expires_at", is("2019-07-30 10:29:28 UTC")))
                .andExpect(status().isOk());
        verify(authenticationService, times(1)).createSession();
    }

    @Test
    public void shouldGetSession() throws Exception {
        //Given
        TokenRest tokenRest = new TokenRest(
                true,
                "2019-07-29 11:44:15 UTC",
                "d18f375cdbe40628ba3fde7f0bf284b2bc58bb53"
        );
        when(authenticationService.createToken()).thenReturn(tokenRest);

        //When & Then
        mockMvc.perform(get("/auth/token").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.expires_at", is("2019-07-29 11:44:15 UTC")))
                .andExpect(jsonPath("$.request_token", is("d18f375cdbe40628ba3fde7f0bf284b2bc58bb53")))
                .andExpect(status().isOk());
        verify(authenticationService, times(1)).createToken();
    }
}