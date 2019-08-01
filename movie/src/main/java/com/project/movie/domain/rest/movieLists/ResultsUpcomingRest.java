package com.project.movie.domain.rest.movieLists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_date;
    private List<Integer> genre_ids;
    private Long id;
    private String original_title;
    private String original_language;
    private String title;
    private String backdrop_path;
    private Double popularity;
    private Double vote_count;
    private Boolean video;
    private Double vote_average;
}
