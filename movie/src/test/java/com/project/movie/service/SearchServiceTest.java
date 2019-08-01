package com.project.movie.service;

import com.project.movie.domain.rest.movies.KeywordRest;
import com.project.movie.domain.rest.search.CollectionsRest;
import com.project.movie.domain.rest.search.CompaniesRest;
import com.project.movie.repository.rest.SearchRepository;
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
public class SearchServiceTest {
    @Autowired
    private SearchService searchService;

    @MockBean
    private SearchRepository searchRepository;

    @TestConfiguration
    static class SearchServiceTestContextConfiguration {
        @Bean
        public SearchService searchService() {
            return new SearchService();
        }
    }

    @Before
    public void setUp(){
        CollectionsRest collectionsRest = new CollectionsRest();
        CompaniesRest companiesRest = new CompaniesRest();
        KeywordRest keywordRest = new KeywordRest();
        Mockito.when(searchRepository.getCollections()).thenReturn(collectionsRest);
        Mockito.when(searchRepository.getCompanies()).thenReturn(companiesRest);
        Mockito.when(searchRepository.getKeywords()).thenReturn(keywordRest);
    }

    @Test
    public void shouldGetCollections() {
        //Given
        CollectionsRest collectionsRest = new CollectionsRest();
        //When
        CollectionsRest result = searchService.searchCollections();
        //Then
        assertEquals(collectionsRest,result);
    }

    @Test
    public void shouldGetCompanies() {
        //Given
        CompaniesRest companiesRest = new CompaniesRest();
        //When
        CompaniesRest result = searchService.searchCompanies();
        //Then
        assertEquals(companiesRest,result);
    }

    @Test
    public void shouldGetKeywords() {
        //Given
        KeywordRest keywordRest = new KeywordRest();
        //When
        KeywordRest result = searchService.searchKeywords();
        //Then
        assertEquals(keywordRest,result);
    }
}
