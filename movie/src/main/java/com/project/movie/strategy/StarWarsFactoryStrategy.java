package com.project.movie.strategy;

import org.springframework.stereotype.Component;

@Component
public class StarWarsFactoryStrategy extends AbstractFactory<StarWarsStrategy, StarWars>{

    @Override
    protected StarWars getKey(StarWarsStrategy starWarsStrategy) {
        return starWarsStrategy.getStarWars();
    }
}
