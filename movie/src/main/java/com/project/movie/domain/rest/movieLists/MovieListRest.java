package com.project.movie.domain.rest.movieLists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.movie.domain.rest.movies.MovieRest;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Builder
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
