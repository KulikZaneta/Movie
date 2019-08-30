package com.project.movie.domain.rest.movie.lists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsUpcomingRest {
    @JsonProperty("poster_path")
    private String posterPath;
    private Boolean adult;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;
    private Long id;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("original_language")
    private String originalLanguage;
    private String title;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    private Double popularity;
    @JsonSetter("vote_count")
    private Double voteCount;
    private Boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
}
