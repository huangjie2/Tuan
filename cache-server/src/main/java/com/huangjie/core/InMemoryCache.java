package com.huangjie.core;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class InMemoryCache implements Cache {
    private final Map<String, String> cache = new ConcurrentHashMap<>();
    /**
     * 获取缓存大小
     */
    public Mono<Integer> size() {
        return Mono.just(cache.size());
    }

    /**
     * 清空缓存
     */
    public Mono<Void> clear() {
        cache.clear();
        return Mono.empty();
    }

    /**
     * 检查键是否存在
     */
    public Mono<Boolean> containsKey(String key) {
        return Mono.just(cache.containsKey(key));
    }

    /**
     * 获取所有键
     */
    public Mono<Set<String>> keys() {
        return Mono.just(cache.keySet());
    }

    /**
     * 批量删除键
     */
    public Mono<Void> deleteAll(Set<String> keys) {
        keys.forEach(cache::remove);
        return Mono.empty();
    }

    /**
     * 批量设置键值对
     */
    public Mono<Void> putAll(Map<String, String> entries) {
        cache.putAll(entries);
        return Mono.empty();
    }

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
