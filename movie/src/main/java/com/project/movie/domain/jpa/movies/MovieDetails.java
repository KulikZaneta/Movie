package com.project.movie.domain.jpa.movies;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private String originalLanguage;
    private String originalTitle;
    private Double popularity;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_company", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<ProductionCompany> productionCompanyRests = new LinkedList<>();
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_countries", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "countries_id"))
    private List<Country> productionCountryRests = new LinkedList<>();
    private LocalDate releaseDate;
    private Double runtime;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_spoken", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "spoken_id"))
    private List<Language> spokenLanguageRests = new LinkedList<>();
    private String title;
    private Long voteAverage;
    @OneToOne(mappedBy = "movieDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, optional = false)
    private Movie movie;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "movieDetails")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<SocialMedia> socialMedia;
    private Long restMovieId;
}
