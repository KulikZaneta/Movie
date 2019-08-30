package com.project.movie.domain.elastic.movies;

import com.project.movie.domain.jpa.movies.Country;
import com.project.movie.domain.jpa.movies.Genre;
import com.project.movie.domain.jpa.movies.Language;
import com.project.movie.domain.jpa.movies.ProductionCompany;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(type = "movie_details", indexName = "movie_details")
public class MovieDetailsCache {
    private Boolean adult;
    private List<Genre> genres;
    @Id
    private String id;
    private String originalLanguage;
    private String originalTitle;
    private Double popularity;
    private List<ProductionCompany> productionCompanyRests;
    private List<Country> productionCountryRests;
    private String releaseDate;
    private Double runtime;
    private List<Language> spokenLanguageRests;
    private String title;
    private Long voteAverage;
    private Long restMovieId;
}
