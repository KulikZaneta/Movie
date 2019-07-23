package com.project.movie.service;


import com.project.movie.domain.rest.movies.KeywordRest;
import com.project.movie.domain.rest.search.CollectionsRest;
import com.project.movie.domain.rest.search.CompaniesRest;
import com.project.movie.repository.rest.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    @Autowired
    private SearchRepository searchRepository;

    public CollectionsRest searchCollections() {
        return searchRepository.getCollections();
    }

    public CompaniesRest searchCompanies() {
        return searchRepository.getCompanies();
    }

    public KeywordRest searchKeywords() {
        return searchRepository.getKeywords();
    }
}
