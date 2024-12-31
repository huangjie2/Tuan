package com.huangjie.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class InMemoryCache implements Cache {
    private final Map<String, String> cache = new ConcurrentHashMap<>();

    @Override
    public Mono<String> get(String key) {
        return Mono.justOrEmpty(cache.get(key));
    }

    @Override
    public Mono<Void> put(String key, String value) {
        cache.put(key, value);
        return Mono.empty();
    }

    @Override
    public Mono<Void> delete(String key) {
        cache.remove(key);
        return Mono.empty();
    }
}
