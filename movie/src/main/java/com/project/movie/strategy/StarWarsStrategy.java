package com.project.movie.strategy;

import lombok.Data;

@Data
public abstract class StarWarsStrategy {
    private StarWars starWars;

    protected StarWarsStrategy(StarWars starWars) {
        this.starWars = starWars;
    }

    public abstract Object get();
}
