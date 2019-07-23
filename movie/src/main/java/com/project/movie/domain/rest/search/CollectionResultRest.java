package com.project.movie.domain.rest.search;

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
public class CollectionResultRest {
    private Boolean adult;
    private String backdrop_path;
    private Long id;
    private String name;
    private String original_language;
    private String original_name;
    private String overview;
    private String poster_path;
}
