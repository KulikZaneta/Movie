package com.project.movie.repository.elastic;


import com.project.movie.domain.elastic.movies.MovieCache;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieCacheRepository extends ElasticsearchRepository<MovieCache, String> {
    MovieCache findByTitle(String title);
}
