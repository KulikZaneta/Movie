package com.project.movie.domain.rest.star.wars.films;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmResultRest {
    private String title;
    @JsonProperty("episode_id")
    private Long episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    private List<String> characters;
    private List<String > planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;
}
