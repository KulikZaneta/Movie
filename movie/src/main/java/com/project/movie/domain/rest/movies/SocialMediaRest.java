package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SocialMediaRest {
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("facebook_id")
    private String facebookId;
    @JsonProperty("instagram_id")
    private String instagramId;
    @JsonProperty("twitter_id")
    private String twitterId;
    private Long id;
}
