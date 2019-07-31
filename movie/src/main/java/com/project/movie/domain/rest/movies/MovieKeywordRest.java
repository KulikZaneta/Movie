package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Builder
public class MovieKeywordRest {
    private Long id;
    private String name;
}
