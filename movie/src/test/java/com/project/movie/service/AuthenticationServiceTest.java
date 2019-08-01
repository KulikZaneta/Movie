package com.project.movie.service;

import com.project.movie.domain.rest.authentication.GuestSessionRest;
import com.project.movie.domain.rest.authentication.TokenRest;
import com.project.movie.repository.rest.AuthenticationRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthenticationServiceTest {
    @Autowired
    private AuthenticationService authenticationService;

    @MockBean
    private AuthenticationRepository authenticationRepository;

    @TestConfiguration
    static class AuthenticationServiceTestContextConfiguration {
        @Bean
        public AuthenticationService authenticationService() {
            return new AuthenticationService();
        }
    }

    @Before
    public void setUp() {
        TokenRest tokenRest = new TokenRest();
        GuestSessionRest guestSessionRest = new GuestSessionRest();
        Mockito.when(authenticationRepository.getGuestSession()).thenReturn(guestSessionRest);
        Mockito.when(authenticationRepository.getToken()).thenReturn(tokenRest);
    }

    @Test
    public void shouldGetCreateSession() {
        //Given
        GuestSessionRest guestSessionRest = new GuestSessionRest();
        //When
        GuestSessionRest result = authenticationService.createSession();
        //Then
        assertEquals(guestSessionRest, result);
    }

    @Test
    public void shouldGetCreateToken() {
        //Given
        TokenRest tokenRest = new TokenRest();
        //When
        TokenRest result = authenticationService.createToken();
        //Then
        assertEquals(tokenRest, result);
    }
}
