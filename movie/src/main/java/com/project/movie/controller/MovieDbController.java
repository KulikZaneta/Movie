package com.project.movie.controller;

import com.project.movie.domain.elastic.MovieCache;
import com.project.movie.domain.rest.movieLists.MovieListRest;
import com.project.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/movie")
public class MovieDbController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/list/{listId}")
    public MovieListRest getMovies(@PathVariable String listId) {
        return movieService.getList(listId);
    }

    @GetMapping("/{id}")
    public MovieCache getMovie(@PathVariable String id) {
        return movieService.getMovie(id);
    }
}

