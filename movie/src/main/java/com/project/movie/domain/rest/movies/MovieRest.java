package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class MovieRest {
    @JsonProperty("vote_average")
    private Double voteAverage;
    private String id;
    private Boolean video;
    @JsonProperty("media_type")
    private String mediaType;
    private String title;
    private Double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    private Boolean adult;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("vote_count")
    private Integer voteCount;
}