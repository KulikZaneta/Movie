package com.project.movie.mapper;

import com.project.movie.domain.elastic.movies.MovieDetailsCache;
import com.project.movie.domain.jpa.movies.*;
import com.project.movie.domain.rest.movies.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieDetailsMapper {
    public MovieDetailsCache mapToMovieDetailsCache(MovieDetails movieDetails) {
        return MovieDetailsCache.builder()
                .adult(movieDetails.getAdult())
                .genres(movieDetails.getGenres())
                .originalLanguage(movieDetails.getOriginalLanguage())
                .originalTitle(movieDetails.getOriginalTitle())
                .popularity(movieDetails.getPopularity())
                .productionCompanyRests(movieDetails.getProductionCompanyRests())
                .productionCountryRests(movieDetails.getProductionCountryRests())
                .releaseDate(String.valueOf(movieDetails.getReleaseDate()))
                .restMovieId(movieDetails.getRestMovieId())
                .runtime(movieDetails.getRuntime())
                .spokenLanguageRests(movieDetails.getSpokenLanguageRests())
                .title(movieDetails.getTitle())
                .voteAverage(movieDetails.getVoteAverage())
                .build();
    }

    public MovieDetails mapToMovieDetails(MovieDetailsRest movieDetailsRest) {
        return MovieDetails.builder()
                .adult(movieDetailsRest.getAdult())
                .genres(mapToListGenre(movieDetailsRest.getGenres()))
                .originalLanguage(movieDetailsRest.getOriginalLanguage())
                .originalTitle(movieDetailsRest.getOriginalTitle())
                .popularity(movieDetailsRest.getPopularity())
                .productionCompanyRests(mapToListProductionCompany(movieDetailsRest.getProductionCompanyRests()))
                .productionCountryRests(mapToListCountry(movieDetailsRest.getProductionCountryRests()))
                .releaseDate(LocalDate.parse(movieDetailsRest.getReleaseDate()))
                .runtime(movieDetailsRest.getRuntime())
                .spokenLanguageRests(mapToListLanguage(movieDetailsRest.getSpokenLanguageRests()))
                .voteAverage(movieDetailsRest.getVoteCount())
                .restMovieId(movieDetailsRest.getId())
                .build();
    }

    public List<Genre> mapToListGenre(List<GenresRest> genres) {
        return genres.stream()
                .map(this::mapToGenre)
                .collect(Collectors.toList());
    }

    public Genre mapToGenre(GenresRest genresRest) {
        return Genre.builder()
                .name(genresRest.getName())
                .build();

    }

    public List<ProductionCompany> mapToListProductionCompany(List<ProductionCompaniesRest> productionCompaniesRests) {
        if (productionCompaniesRests == null) {
            return new ArrayList<>();
        }
        return productionCompaniesRests.stream()
                .map(this::mapToProductionCompany)
                .collect(Collectors.toList());
    }

    public ProductionCompany mapToProductionCompany(ProductionCompaniesRest productionCompaniesRest) {
        return ProductionCompany.builder()
                .logoPath(productionCompaniesRest.getLogoPath())
                .name(productionCompaniesRest.getName())
                .originCountry(productionCompaniesRest.getOriginCountry())
                .build();
    }

    public List<Country> mapToListCountry(List<ProductionCountriesRest> productionCountriesRests) {
        if (productionCountriesRests == null) {
            return new ArrayList<>();
        }
        return productionCountriesRests.stream()
                .map(this::mapToCountry)
                .collect(Collectors.toList());
    }

    public Country mapToCountry(ProductionCountriesRest productionCountriesRest) {
        return Country.builder()
                .iso(productionCountriesRest.getIso())
                .name(productionCountriesRest.getName())
                .build();

    }

    public List<Language> mapToListLanguage(List<SpokenLanguageRest> spokenLanguageRests) {
        if (spokenLanguageRests == null) {
            return new ArrayList<>();
        }
        return spokenLanguageRests.stream()
                .map(this::mapToLanguage)
                .collect(Collectors.toList());
    }

    public Language mapToLanguage(SpokenLanguageRest spokenLanguageRest) {
        return Language.builder()
                .iso(spokenLanguageRest.getIso())
                .name(spokenLanguageRest.getName())
                .build();
    }
}
