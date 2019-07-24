package com.project.movie.domain.elastic.movies;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(type = "genre", indexName = "genre")
public class GenreCache {
    @Id
    @GeneratedValue
    private String id;
    private String name;
}
