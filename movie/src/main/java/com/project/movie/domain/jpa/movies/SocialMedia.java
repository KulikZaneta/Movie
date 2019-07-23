package com.project.movie.domain.jpa.movies;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class SocialMedia {
    private String imdbId;
    private String facebookId;
    private String instagramId;
    private String twitterId;
    @Id
    @GeneratedValue
    private Long id;
}
