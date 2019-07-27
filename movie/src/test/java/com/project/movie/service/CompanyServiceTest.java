package com.project.movie.service;

import com.project.movie.domain.rest.company.CompanyDetailsRest;
import com.project.movie.domain.rest.company.OtherNameCompanyRest;
import com.project.movie.repository.rest.CompanyRepository;
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
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @MockBean
    private CompanyRepository companyRepository;

    @TestConfiguration
    static class CompanyServiceTestContextConfiguration {
        @Bean
        public CompanyService companyService() {
            return new CompanyService();
        }
    }

    @Before
    public void setUp(){
        CompanyDetailsRest companyDetailsRest = new CompanyDetailsRest();
        OtherNameCompanyRest otherNameCompanyRest = new OtherNameCompanyRest();
        Mockito.when(companyRepository.getCompanyDetails(1L)).thenReturn(companyDetailsRest);
        Mockito.when(companyRepository.getOtherName(2L)).thenReturn(otherNameCompanyRest);
        Mockito.when(companyRepository.getCompanyDetails(3L)).thenReturn(null);
        Mockito.when(companyRepository.getOtherName(4L)).thenReturn(null);
    }

    @Test
    public void shouldGetCompanyDetails() {
        //Given
        CompanyDetailsRest companyDetailsRest = new CompanyDetailsRest();
        //When
         CompanyDetailsRest result = companyService.getCompanyDetails(1L);
        //Then
        assertEquals(companyDetailsRest,result);
    }

    @Test
    public void shouldGetOtherName() {
        //Given
        OtherNameCompanyRest otherNameCompanyRest = new OtherNameCompanyRest();
        //When
        OtherNameCompanyRest result = companyService.getOtherName(2L);
        //Then
        assertEquals(otherNameCompanyRest,result);
    }

    @Test
    public void shouldEmptyGetCompanyDetails() {
        //Given
        CompanyDetailsRest companyDetailsRest = null;
        //When
        CompanyDetailsRest result = companyService.getCompanyDetails(3L);
        //Then
        assertEquals(companyDetailsRest,result);
    }

    @Test
    public void shouldEmptyGetOtherName() {
        //Given
        OtherNameCompanyRest otherNameCompanyRest = null;
        //When
        OtherNameCompanyRest result = companyService.getOtherName(4L);
        //Then
        assertEquals(otherNameCompanyRest,result);
    }



}
