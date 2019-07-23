package com.project.movie.domain.rest.movies;

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
public class MovieDetailsRest {
    private Boolean adult;
    private String backdrop_path;
    private BelongToCollectionRest belongs_to_collection;
    private Integer budget;
    private List<GenresRest> genres;
    private String homepage;
    private Long id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private List<ProductionCompaniesRest> productionCompanyRests;
    private List<ProductionCountriesRest> productionCountryRests;
    private String release_date;
    private Double revenue;
    private Double runtime;
    private List<SpokenLanguageRest> spokenLanguageRests;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Long vote_count;


}
