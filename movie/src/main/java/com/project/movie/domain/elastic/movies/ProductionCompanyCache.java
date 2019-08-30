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
@Document(type = "production_company", indexName = "production_company")
public class ProductionCompanyCache {
    private String name;
    @Id
    @GeneratedValue
    private String id;
    private String logoPath;
    private String originCountry;
}
