package com.project.movie.domain.elastic.movies;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(type = "movie", indexName = "movie")
public class MovieCache {
    @Id
    private String id;
    private String title;
    private String originalLanguage;
    private String releaseDate;
    private Double popularity;
    private Long restId;
}
