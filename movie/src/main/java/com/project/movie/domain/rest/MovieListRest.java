package com.project.movie.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class MovieListRest {
    private Integer item_count;
    private String name;
    private String created_by;
    private String description;
    private Integer favorite_count;
    private String id;
    private List<MovieRest> items;
    private String iso_639_1;
    private String poster_path;
}
