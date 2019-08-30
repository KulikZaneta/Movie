package com.project.movie.domain.rest.star.wars.species;

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
public class SpeciesResultRest {
    private String name;
    private String classification;
    private String designation;
    @JsonProperty("average_height")
    private String averageHeight;
    @JsonProperty("skin_colors")
    private String skinColors;
    @JsonProperty("hair_colors")
    private String hairColors;
    @JsonProperty("eye_colors")
    private String eyeColors;
    @JsonProperty("average_lifespan")
    private String averageLifespan;
    private String homeworld;
    private String language;
    private List<String> people;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}
