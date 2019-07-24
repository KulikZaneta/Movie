package com.project.movie.controller;

import com.project.movie.domain.rest.company.CompanyDetailsRest;
import com.project.movie.domain.rest.company.OtherNameCompanyRest;
import com.project.movie.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyRepository {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/details/{restCompanyId}")
    public CompanyDetailsRest getCompanyDetails(@PathVariable Long restCompanyId) {
        return companyService.getCompanyDetails(restCompanyId);
    }

    @GetMapping("/other-name/{restCompanyId}")
    public OtherNameCompanyRest getOtherName(@PathVariable Long restCompanyId) {
        return companyService.getOtherName(restCompanyId);
    }
}
