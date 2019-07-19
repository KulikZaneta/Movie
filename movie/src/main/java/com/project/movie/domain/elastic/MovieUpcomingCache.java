package com.project.movie.domain.elastic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(type = "movie_upcoming", indexName = "movie_upcoming")
public class MovieUpcomingCache {
    @Id
    private String id;
    private String page;
    private LocalDate maximum;
    private LocalDate minimum;

}
