package com.project.movie.domain.rest.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class DetailsResultRest {
    private String author;
    private String content;
    private String id;
    private String url;
}
