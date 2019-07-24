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
@Document(type = "country", indexName = "country")
public class CountryCache {
    private String iso;
    private String name;
    @Id
    @GeneratedValue
    private Long id;
}
