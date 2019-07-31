package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ReviewsRest {
    private Long id;
    private String page;
    @Singular
    private List<DetailsResultRest> results;
    private Long total_pages;
    private Long total_results;
}
