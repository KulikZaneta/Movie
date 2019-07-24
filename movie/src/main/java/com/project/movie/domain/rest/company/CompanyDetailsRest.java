package com.project.movie.domain.rest.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDetailsRest {
    private String description;
    private String headquarters;
    private String homepage;
    private Long id;
    private String logo_path;
    private String name;
    private String origin_country;
    private String parent_company;
}
