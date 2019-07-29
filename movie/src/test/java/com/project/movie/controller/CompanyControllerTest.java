package com.project.movie.controller;

import com.google.gson.Gson;
import com.project.movie.domain.rest.authentication.GuestSessionRest;
import com.project.movie.domain.rest.company.CompanyDetailsRest;
import com.project.movie.domain.rest.company.NameResultRest;
import com.project.movie.domain.rest.company.OtherNameCompanyRest;
import com.project.movie.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Test
    public void getCompanyDetails() throws Exception {
        //Given
        CompanyDetailsRest companyDetailsRest = new CompanyDetailsRest(
                "Marvel Cinematic Universe ",
                "Burbank, California, USA",
                "http://www.marvel.com",
                420L,
                "/hUzeosd33nzE5MCNsZxCGEKTXaQ.png",
                "Marvel Studios",
                "US",
                null

        );
        when(companyService.getCompanyDetails(any())).thenReturn(companyDetailsRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(companyDetailsRest);

        //When & Then
        mockMvc.perform(get("/company/details/420").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        //verify(companyService, times(1)).getCompanyDetails(anyLong());
        System.out.println(companyDetailsRest);

    }

    @Test
    public void getOtherName() {
        //Given
        OtherNameCompanyRest otherNameCompanyRest = new OtherNameCompanyRest();
    }
}