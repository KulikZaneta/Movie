package com.project.movie.service;

import com.project.movie.domain.rest.company.CompanyDetailsRest;
import com.project.movie.domain.rest.company.OtherNameCompanyRest;
import com.project.movie.repository.rest.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyDetailsRest getCompanyDetails(Long restCompanyId) {
        return companyRepository.getCompanyDetails(restCompanyId);
    }

    public OtherNameCompanyRest getOtherName(Long restCompanyId) {
        return companyRepository.getOtherName(restCompanyId);
    }
}
