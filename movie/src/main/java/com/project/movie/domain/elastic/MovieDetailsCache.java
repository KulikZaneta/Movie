package com.project.movie.domain.elastic;

import com.project.movie.domain.rest.GenresRest;
import com.project.movie.domain.rest.ProductionCompaniesRest;
import com.project.movie.domain.rest.ProductionCountriesRest;
import com.project.movie.domain.rest.SpokenLanguageRest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(type = "movieDetails", indexName = "movieDetails")
public class MovieDetailsCache {
    private Boolean adult;
    private List<GenresRest> genres;
    @Id
    private String id;
    private String original_language;
    private String original_title;
    private Double popularity;
    private List<ProductionCompaniesRest> productionCompanyRests;
    private List<ProductionCountriesRest> productionCountryRests;
    private LocalDate release_date;
    private Double runtime;
    private List<SpokenLanguageRest> spokenLanguageRests;
    private String title;
    private Long vote_average;
}
