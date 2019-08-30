package com.project.movie.strategy;

import lombok.Data;

import java.util.List;

@Data
public abstract class StarWarsStrategy<T> {
    private StarWars starWars;

    protected StarWarsStrategy(StarWars starWars) {
        this.starWars = starWars;
    }

    public abstract List<T> get();
}
