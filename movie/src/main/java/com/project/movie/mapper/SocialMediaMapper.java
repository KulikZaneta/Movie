package com.project.movie.mapper;

import com.project.movie.domain.jpa.movies.SocialMedia;
import com.project.movie.domain.rest.movies.SocialMediaRest;
import org.springframework.stereotype.Component;

@Component
public class SocialMediaMapper {
    public SocialMedia mapToSocialMedia(SocialMediaRest socialMediaRest) {
        return SocialMedia.builder()
                .facebookId(socialMediaRest.getFacebook_id())
                .imdbId(socialMediaRest.getImdb_id())
                .instagramId(socialMediaRest.getInstagram_id())
                .twitterId(socialMediaRest.getTwitter_id())
                .build();
    }

}
