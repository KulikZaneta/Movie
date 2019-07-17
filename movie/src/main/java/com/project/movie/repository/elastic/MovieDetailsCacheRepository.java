package com.project.movie.repository.elastic;

import com.project.movie.domain.elastic.MovieDetailsCache;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieDetailsCacheRepository extends ElasticsearchRepository<MovieDetailsCache, String> {
}
