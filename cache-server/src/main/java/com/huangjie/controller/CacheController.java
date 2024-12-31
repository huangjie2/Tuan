package com.huangjie.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huangjie.core.Cache;

import reactor.core.publisher.Mono;

@RestController
public class CacheController {
    private final Cache cache;

    public CacheController(Cache cache) {
        this.cache = cache;
    }

    @GetMapping("/get/{key}")
    public Mono<String> get(@PathVariable String key) {
        return cache.get(key);
    }

    //设置输入输出值类型
    @PostMapping("/put/{key}")
    public Mono<Void> put(@PathVariable String key, @RequestBody String value) {
        return cache.put(key, value);
    }

    @DeleteMapping("/delete/{key}")
    public Mono<Void> delete(@PathVariable String key) {
        return cache.delete(key);
    }
}