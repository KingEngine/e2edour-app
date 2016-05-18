
package com.e2edour.common.cache.support.lru;


import com.e2edour.common.cache.Cache;
import com.e2edour.common.cache.CacheFactory;
import com.e2edour.common.cache.support.AbstractCacheFactory;

public class LruCacheFactory extends AbstractCacheFactory {
    private LruCacheFactory() {
    }

    protected Cache createCache(int maxSize) {
        return new LruCache(maxSize);
    }

    public static CacheFactory getInstance() {
        return LruCacheFactory.LruCacheFactoryHolder.instance;
    }

    static class LruCacheFactoryHolder {
        static final CacheFactory instance = new LruCacheFactory();

        LruCacheFactoryHolder() {
        }
    }
}
