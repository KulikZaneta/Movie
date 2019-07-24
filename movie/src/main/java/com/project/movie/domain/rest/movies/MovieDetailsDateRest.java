package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String iso_639_1;
    private String release_date;
    private Long type;
    private String note;
}
