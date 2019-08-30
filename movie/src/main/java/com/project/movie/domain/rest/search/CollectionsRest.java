package com.project.movie.domain.rest.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("total_pages")
    private Long totalPages;
    @JsonProperty("total_results")
    private Long totalResults;
}
