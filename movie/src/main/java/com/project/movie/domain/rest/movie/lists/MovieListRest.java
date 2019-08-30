package com.project.movie.domain.rest.movie.lists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("item_count")
    private Integer itemCount;
    private String name;
    @JsonProperty("created_by")
    private String createdBy;
    private String description;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    private String id;
    private List<MovieRest> items;
    @JsonProperty("iso_639_1")
    private String iso;
    @JsonProperty("poster_path")
    private String posterPath;
}
