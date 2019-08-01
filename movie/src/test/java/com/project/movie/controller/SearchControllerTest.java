package com.project.movie.controller;

import com.project.movie.domain.rest.movies.KeywordRest;
import com.project.movie.domain.rest.movies.MovieKeywordRest;
import com.project.movie.domain.rest.search.CollectionsRest;
import com.project.movie.domain.rest.search.CompaniesRest;
import com.project.movie.service.SearchService;
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
@WebMvcTest(SearchController.class)
public class SearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService searchService;

    @Test
    public void shouldEmptyGetCollections() throws Exception {
        //Given
        CollectionsRest collectionsRest = new CollectionsRest();
        when(searchService.searchCollections()).thenReturn(collectionsRest);

        //When & Then
        mockMvc.perform(get("/search/collections").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchCollections();
    }

    @Test
    public void shouldGetCollections() throws Exception {
        //Given
        CollectionsRest collectionsRest =  CollectionsRest.builder()
                .page(1L)
                .total_pages(2L)
                .total_results(3L)
                .build();
        when(searchService.searchCollections()).thenReturn(collectionsRest);

        //When & Then
        mockMvc.perform(get("/search/collections").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.page", is(1)))
                .andExpect(jsonPath("$.total_pages", is(2)))
                .andExpect(jsonPath("$.total_results", is(3)));
        verify(searchService, times(1)).searchCollections();
        System.out.println(collectionsRest);
    }

    @Test
    public void shoulEmptyGetCompanies() throws Exception {
        //Given
        CompaniesRest companiesRest = new CompaniesRest();
        when(searchService.searchCompanies()).thenReturn(companiesRest);

        //When & Then
        mockMvc.perform(get("/search/companies").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchCompanies();
    }

    @Test
    public void shoulGetCompanies() throws Exception {
        //Given
        CompaniesRest companiesRest =  CompaniesRest.builder()
                .page(1L)
                .total_pages(2L)
                .total_results(3L)
                .build();
        when(searchService.searchCompanies()).thenReturn(companiesRest);

        //When & Then
        mockMvc.perform(get("/search/companies").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(jsonPath("$.page", is(1)))
                .andExpect(jsonPath("$.total_pages", is(2)))
                .andExpect(jsonPath("$.total_results", is(3)))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchCompanies();
    }

    @Test
    public void shouldEmptyGetKeywords() throws Exception {
        //Given
        KeywordRest keywordRest = new KeywordRest(
        );
        when(searchService.searchKeywords()).thenReturn(keywordRest);

        //When & Then
        mockMvc.perform(get("/search/keywords").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchKeywords();
    }

    @Test
    public void shouldGetKeywords() throws Exception {
        //Given
        KeywordRest keywordRest =  KeywordRest.builder()
                .id(1L)
                .keyword(MovieKeywordRest.builder()
                        .name("a")
                        .id(2L)
                        .build())
                .build();
        when(searchService.searchKeywords()).thenReturn(keywordRest);

        //When & Then
        mockMvc.perform(get("/search/keywords").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchKeywords();
    }
}