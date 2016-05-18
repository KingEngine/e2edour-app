package com.e2edour.common.cache;

public interface Cache {
    void put(Object var1, Object var2);

    Object get(Object var1);

    Object remove(Object var1);

    void clear();
}
