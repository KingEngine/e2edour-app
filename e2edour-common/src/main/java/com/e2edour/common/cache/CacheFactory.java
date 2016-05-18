package com.e2edour.common.cache;


import com.e2edour.common.cache.Cache;
public interface CacheFactory {
    Cache getCache(String var1);

    Cache getCache(String var1, int var2);
}
