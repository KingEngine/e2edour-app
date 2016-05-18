//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.e2edour.common.cache.support;

import com.e2edour.common.cache.Cache;
import com.e2edour.common.cache.CacheFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractCacheFactory implements CacheFactory {
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap();
    private static final int DEFAULT_MAX_SIZE = 1000;

    public AbstractCacheFactory() {
    }

    public Cache getCache(String key) {
        Cache cache = (Cache)this.caches.get(key);
        if(cache == null) {
            this.caches.put(key, this.createCache(1000));
            cache = (Cache)this.caches.get(key);
        }

        return cache;
    }

    public Cache getCache(String key, int maxSize) {
        Cache cache = (Cache)this.caches.get(key);
        if(cache == null) {
            if(maxSize < 1) {
                maxSize = 1000;
            }

            this.caches.put(key, this.createCache(maxSize));
            cache = (Cache)this.caches.get(key);
        }

        return cache;
    }

    protected abstract Cache createCache(int var1);
}
