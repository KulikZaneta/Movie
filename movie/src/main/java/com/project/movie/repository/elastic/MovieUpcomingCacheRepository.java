package com.project.movie.repository.elastic;

import com.project.movie.domain.elastic.movies.MovieUpcomingCache;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieUpcomingCacheRepository extends ElasticsearchRepository<MovieUpcomingCache, String> {
}
