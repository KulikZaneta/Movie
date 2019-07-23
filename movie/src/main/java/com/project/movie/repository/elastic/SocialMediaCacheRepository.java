package com.project.movie.repository.elastic;

import com.project.movie.domain.elastic.movies.SocialMediaCache;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SocialMediaCacheRepository extends ElasticsearchRepository<SocialMediaCache, String> {
}
