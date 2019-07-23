package com.project.movie.domain.rest.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BelongToCollectionRest {
    private String id;
    private String name;
    private String poster_path;
    private String backdrop_path;

}
