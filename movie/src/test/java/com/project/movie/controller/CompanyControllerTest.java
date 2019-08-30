package com.project.movie.controller;

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

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Test
    public void shouldGetCompanyDetails() throws Exception {
        //Given
        CompanyDetailsRest companyDetailsRest = new CompanyDetailsRest(
                "Marvel Cinematic Universe",
                "Burbank, California, USA",
                "http://www.marvel.com",
                420L,
                "/hUzeosd33nzE5MCNsZxCGEKTXaQ.png",
                "Marvel Studios",
                "US",
                "test");
        when(companyService.getCompanyDetails(any())).thenReturn(companyDetailsRest);

        //When & Then
        mockMvc.perform(get("/company/details/420").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("Marvel Cinematic Universe")))
                .andExpect(jsonPath("$.headquarters", is("Burbank, California, USA")))
                .andExpect(jsonPath("$.homepage", is("http://www.marvel.com")))
                .andExpect(jsonPath("$.id", is(420)))
                .andExpect(jsonPath("$.logoPath", is("/hUzeosd33nzE5MCNsZxCGEKTXaQ.png")))
                .andExpect(jsonPath("$.name", is("Marvel Studios")))
                .andExpect(jsonPath("$.originCountry", is("US")))
                .andExpect(jsonPath("$.parentCompany", is("test")));
        verify(companyService, times(1)).getCompanyDetails(anyLong());
    }

    @Test
    public void shouldGetOtherName() throws Exception {
        //Given
        OtherNameCompanyRest otherNameCompanyRest = OtherNameCompanyRest.builder()
                .id(1L)
                .result(NameResultRest.builder()
                        .name("testName")
                        .type("testType")
                        .build())
                .build();
        when(companyService.getOtherName(1L)).thenReturn(otherNameCompanyRest);

        //When&&Then
        mockMvc.perform(get("/company/other-name/1").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
        verify(companyService, times(1)).getOtherName(anyLong());
    }
}