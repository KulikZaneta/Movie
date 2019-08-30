package com.project.movie.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractFactory<S, E> {
    @Autowired
    private List<S> services;

    private Map<E, S> serviceMap = new HashMap<>();

    @PostConstruct//wywoluje sie po konstruktorze
    public void init() {
        serviceMap = services.stream()
                .collect(Collectors.toMap(this::getKey, x -> x));
    }

    protected abstract E getKey(S s);

    public S getByEnum(E e) {
        return serviceMap.get(e);
    }
}
