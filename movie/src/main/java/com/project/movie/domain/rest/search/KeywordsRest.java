package com.project.movie.domain.rest.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeywordsRest {
    private Long page;
    private List<KeywordResultsRest> results;
    @JsonProperty("total_pages")
    private Long totalPages;
    @JsonProperty("total_results")
    private Long totalResults;
}
