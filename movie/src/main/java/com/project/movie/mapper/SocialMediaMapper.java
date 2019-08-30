package com.project.movie.mapper;

import com.project.movie.domain.jpa.movies.SocialMedia;
import com.project.movie.domain.rest.movies.SocialMediaRest;
import org.springframework.stereotype.Component;

@Component
public class SocialMediaMapper {
    public SocialMedia mapToSocialMedia(SocialMediaRest socialMediaRest) {
        return SocialMedia.builder()
                .facebookId(socialMediaRest.getFacebookId())
                .imdbId(socialMediaRest.getImdbId())
                .instagramId(socialMediaRest.getInstagramId())
                .twitterId(socialMediaRest.getTwitterId())
                .build();
    }
}
