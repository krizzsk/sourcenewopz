package com.didi.address.cache;

public class CacheData<T> {
    public T data;
    public String version;

    CacheData(String str, T t) {
        this.version = str;
        this.data = t;
    }
}
