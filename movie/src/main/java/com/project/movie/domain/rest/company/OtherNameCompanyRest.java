package com.project.movie.domain.rest.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class OtherNameCompanyRest {
    private Long id;
    @Singular
    private List<NameResultRest> results;
}
