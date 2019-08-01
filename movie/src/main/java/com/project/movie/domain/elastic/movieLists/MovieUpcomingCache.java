package com.project.movie.domain.elastic.movieLists;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(type = "movie_upcoming", indexName = "movie_upcoming")
public class MovieUpcomingCache {
    @Id
    private String id;
    private String maximum;
    private String minimum;
}
