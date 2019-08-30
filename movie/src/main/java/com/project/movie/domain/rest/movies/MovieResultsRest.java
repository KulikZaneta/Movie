package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class MovieResultsRest {
    @JsonProperty("iso_3166_1")
    private String iso;
    @JsonProperty("release_dates")
    private List<MovieDetailsDateRest> releaseDates;
}
