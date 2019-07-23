package com.project.movie.controller;

import com.project.movie.domain.rest.movies.KeywordRest;
import com.project.movie.domain.rest.search.CollectionsRest;
import com.project.movie.domain.rest.search.CompaniesRest;
import com.project.movie.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/collections")
    public CollectionsRest getCollections() {
        return searchService.searchCollections();
    }

    @GetMapping("/companies")
    public CompaniesRest getCompanies() {
        return searchService.searchCompanies();
    }

    @GetMapping("/keywords")
    public KeywordRest getKeywords() {
        return searchService.searchKeywords();
    }

}
