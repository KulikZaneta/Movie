package com.project.movie.domain.jpa;

import com.project.movie.domain.rest.GenresRest;
import com.project.movie.domain.rest.ProductionCompaniesRest;
import com.project.movie.domain.rest.ProductionCountriesRest;
import com.project.movie.domain.rest.SpokenLanguageRest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class MovieDetails {
    private Boolean adult;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new LinkedList<>();
    @Id
    @GeneratedValue
    private Long id;
    private String original_language;
    private String original_title;
    private Double popularity;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_company", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<ProductionCompany> productionCompanyRests = new LinkedList<>();
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_countries", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "countries_id"))
    private List<Country> productionCountryRests = new LinkedList<>();
    private LocalDate release_date;
    private Double runtime;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_spoken", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "spoken_id"))
    private List<Language> spokenLanguageRests = new LinkedList<>();
    private String title;
    private Long vote_average;
    @OneToOne(mappedBy = "movieDetails", orphanRemoval = true)
    private Movie movie;
}
