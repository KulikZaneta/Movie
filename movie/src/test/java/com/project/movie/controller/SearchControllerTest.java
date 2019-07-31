package com.project.movie.controller;

import com.google.gson.Gson;
import com.project.movie.domain.rest.movies.KeywordRest;
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
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchController.class)
public class SearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService searchService;

    //Done---> null
    @Test
    public void shouldEmptyGetCollections() throws Exception {
        //Given
        CollectionsRest collectionsRest = new CollectionsRest();
        when(searchService.searchCollections()).thenReturn(collectionsRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(collectionsRest);

        //When & Then
        mockMvc.perform(get("/search/collections").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchCollections();
    }

    //obiekt - lista
    @Test
    public void shouldGetCollections() throws Exception {
        //Given
        CollectionsRest collectionsRest = new CollectionsRest();
        when(searchService.searchCollections()).thenReturn(collectionsRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(collectionsRest);

        //When & Then
        mockMvc.perform(get("/search/collections").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchCollections();
        System.out.println(collectionsRest);
    }


    //Done---> null
    @Test
    public void shoulEmptyGetCompanies() throws Exception {
        //Given
        CompaniesRest companiesRest = new CompaniesRest(
        );
        when(searchService.searchCompanies()).thenReturn(companiesRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(companiesRest);

        //When & Then
        mockMvc.perform(get("/search/companies").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchCompanies();
    }

    //obiekt - lista
    @Test
    public void shoulGetCompanies() throws Exception {
        //Given
        CompaniesRest companiesRest = new CompaniesRest(
        );
        when(searchService.searchCompanies()).thenReturn(companiesRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(companiesRest);

        //When & Then
        mockMvc.perform(get("/search/companies").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchCompanies();
        System.out.println(companiesRest);
    }

    //Done--->null
    @Test
    public void shouldEmptyGetKeywords() throws Exception {
        //Given
        KeywordRest keywordRest = new KeywordRest(
        );
        when(searchService.searchKeywords()).thenReturn(keywordRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(keywordRest);

        //When & Then
        mockMvc.perform(get("/search/keywords").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchKeywords();
    }

    //obiekt - lista
    @Test
    public void shouldGetKeywords() throws Exception {
        //Given
        KeywordRest keywordRest = new KeywordRest();
        when(searchService.searchKeywords()).thenReturn(keywordRest);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(keywordRest);

        //When & Then
        mockMvc.perform(get("/search/keywords").content(String.valueOf(MediaType.APPLICATION_JSON))
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(searchService, times(1)).searchKeywords();
        System.out.println(keywordRest);
    }
}