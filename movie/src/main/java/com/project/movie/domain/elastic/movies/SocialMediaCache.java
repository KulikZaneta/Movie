package com.project.movie.domain.elastic.movies;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(type = "social_media", indexName = "social_media")
public class SocialMediaCache {
    private String imdbId;
    private String facebookId;
    private String instagramId;
    private String twitterId;
    @Id
    private String id;
}
