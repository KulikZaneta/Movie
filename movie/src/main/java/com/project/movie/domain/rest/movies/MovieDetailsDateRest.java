package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailsDateRest {
    private String certification;
    @JsonProperty("iso_639_1")
    private String iso;
    @JsonProperty("release_date")
    private String releaseDate;
    private Long type;
    private String note;
}
