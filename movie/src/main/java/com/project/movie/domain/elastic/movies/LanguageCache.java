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
@Document(type = "language", indexName = "language")
public class LanguageCache {
    private String iso;
    private String name;
    @Id
    @GeneratedValue
    private String id;
}
