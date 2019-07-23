package com.project.movie.domain.elastic;

import com.project.movie.domain.jpa.Country;
import com.project.movie.domain.jpa.Genre;
import com.project.movie.domain.jpa.Language;
import com.project.movie.domain.jpa.ProductionCompany;
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
    private String original_language;
    private String original_title;
    private Double popularity;
    private List<ProductionCompany> productionCompanyRests;
    private List<Country> productionCountryRests;
    private String release_date;
    private Double runtime;
    private List<Language> spokenLanguageRests;
    private String title;
    private Long vote_average;
    private Long restMovieId;
}
