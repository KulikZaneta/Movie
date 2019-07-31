package com.project.movie.domain.rest.movieLists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class MovieUpcomingRest {
    private Long page;
    private List<ResultsUpcomingRest> results;
    private DateUpcomingRest dates;
    private Long total_pages;
    private Long total_results;
}
