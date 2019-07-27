package com.project.movie.repository.rest;

import com.project.movie.domain.rest.movies.KeywordRest;
import com.project.movie.domain.rest.search.CollectionsRest;
import com.project.movie.domain.rest.search.CompaniesRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
@Slf4j
public class SearchRepository {
    @Value("${url.movieDb}")
    private String movieDb;

    @Value("${api.key.movie}")
    private String apiKey;

    public CollectionsRest getCollections() {
        return new RestTemplate().getForObject(movieDb.concat("/search/collection?" + apiKey + "&language=en-US&query=Thor&page=1"),CollectionsRest.class);
    }

    public CompaniesRest getCompanies() {
        return new RestTemplate().getForObject(movieDb.concat("/search/company?" + apiKey + "&query=Thor&page=1"),CompaniesRest.class);
    }

    public KeywordRest getKeywords() {
        return new RestTemplate().getForObject(movieDb.concat("/search/keyword?" + apiKey + "&query=Thor&page=1"),KeywordRest.class);
    }
}
