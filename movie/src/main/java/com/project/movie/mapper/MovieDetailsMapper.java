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
                .original_language(movieDetails.getOriginal_language())
                .original_title(movieDetails.getOriginal_title())
                .popularity(movieDetails.getPopularity())
                .productionCompanyRests(movieDetails.getProductionCompanyRests())
                .productionCountryRests(movieDetails.getProductionCountryRests())
                .release_date(String.valueOf(movieDetails.getRelease_date()))
                .restMovieId(movieDetails.getRestMovieId())
                .runtime(movieDetails.getRuntime())
                .spokenLanguageRests(movieDetails.getSpokenLanguageRests())
                .title(movieDetails.getTitle())
                .vote_average(movieDetails.getVote_average())
                .build();
    }

    public MovieDetails mapToMovieDetails(MovieDetailsRest movieDetailsRest) {
        return MovieDetails.builder()
                .adult(movieDetailsRest.getAdult())
                .genres(mapToListGenre(movieDetailsRest.getGenres()))
                .original_language(movieDetailsRest.getOriginal_language())
                .original_title(movieDetailsRest.getOriginal_title())
                .popularity(movieDetailsRest.getPopularity())
                .productionCompanyRests(mapToListProductionCompany(movieDetailsRest.getProductionCompanyRests()))
                .productionCountryRests(mapToListCountry(movieDetailsRest.getProductionCountryRests()))
                .release_date(LocalDate.parse(movieDetailsRest.getRelease_date()))
                .runtime(movieDetailsRest.getRuntime())
                .spokenLanguageRests(mapToListLanguage(movieDetailsRest.getSpokenLanguageRests()))
                .vote_average(movieDetailsRest.getVote_count())
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
                .logo_path(productionCompaniesRest.getLogo_path())
                .name(productionCompaniesRest.getName())
                .origin_country(productionCompaniesRest.getOrigin_country())
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
                .iso(productionCountriesRest.getIso_3166_1())
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
                .iso(spokenLanguageRest.getIso_639_1())
                .name(spokenLanguageRest.getName())
                .build();
    }
}
