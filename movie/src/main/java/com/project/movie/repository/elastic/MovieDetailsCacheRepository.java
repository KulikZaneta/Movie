package com.project.movie.repository.elastic;

import com.project.movie.domain.elastic.MovieDetailsCache;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface MovieDetailsCacheRepository extends ElasticsearchRepository<MovieDetailsCache, String> {
    MovieDetailsCache findByRestMovieId(Long id);
}
