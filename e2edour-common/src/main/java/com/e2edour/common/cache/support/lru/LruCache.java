//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.e2edour.common.cache.support.lru;


import com.e2edour.common.cache.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache implements Cache {
    private final LinkedHashMap store;

    public LruCache(final int maxSize) {
        this.store = new LinkedHashMap();
//        this.store = new LinkedHashMap(){
//            @Override
//            protected boolean removeEldestEntry(Entry eldest) {
//                return this.size() > maxSize;
//            }
//        };
    }

    public void put(Object key, Object value) {
        Map var3 = this.store;
        synchronized(this.store) {
            this.store.put(key, value);
        }
    }

    public Object get(Object key) {
        Map var2 = this.store;
        synchronized(this.store) {
            return this.store.get(key);
        }
    }

    public Object remove(Object key) {
        Map var2 = this.store;
        synchronized(this.store) {
            return this.store.remove(key);
        }
    }

    public void clear() {
        Map var1 = this.store;
        synchronized(this.store) {
            this.store.clear();
        }
    }
}
