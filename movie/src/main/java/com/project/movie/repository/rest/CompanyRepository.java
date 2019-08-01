package com.project.movie.repository.rest;

import com.project.movie.domain.rest.company.CompanyDetailsRest;
import com.project.movie.domain.rest.company.OtherNameCompanyRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CompanyRepository {
    @Value("${url.movieDb}")
    private String movieDb;

    @Value("${api.key.movie}")
    private String apiKey;

    public CompanyDetailsRest getCompanyDetails(Long restCompanyId) {
        return new RestTemplate().getForObject(movieDb.concat("/company/" + restCompanyId + "?api_key=" + apiKey),CompanyDetailsRest.class);
    }

    public OtherNameCompanyRest getOtherName(Long restCompanyId) {
        return new RestTemplate().getForObject(movieDb.concat("/company/" + restCompanyId + "/alternative_names?api_key=" + apiKey),OtherNameCompanyRest.class);
    }
}
