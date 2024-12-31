package com.huangjie.core;

/**
 * @author kent
 */

import reactor.core.publisher.Mono;
public interface Cache {
    Mono<String> get(String key);
    Mono<Void> put(String key, String value);
    Mono<Void> delete(String key);

}