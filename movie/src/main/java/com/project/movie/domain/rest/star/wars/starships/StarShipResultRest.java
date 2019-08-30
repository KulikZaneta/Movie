package com.project.movie.domain.rest.star.wars.starships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.movie.domain.rest.star.wars.GenericResultRest;
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
public class StarShipResultRest extends GenericResultRest {
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;
    @JsonProperty("MGLT")
    private String mglt;
    @JsonProperty("starship_class")
    private String starshipClass;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}
