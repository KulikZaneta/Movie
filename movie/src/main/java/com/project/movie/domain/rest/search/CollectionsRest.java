package com.project.movie.domain.rest.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class CollectionsRest {
    private Long page;
    private List<CollectionResultRest> results;
    private Long total_pages;
    private Long total_results;
}
