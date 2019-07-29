package com.project.movie.repository.jpa.movies;

import com.project.movie.domain.jpa.movies.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {
    SocialMedia findByFacebookId(String facebookId);

}
