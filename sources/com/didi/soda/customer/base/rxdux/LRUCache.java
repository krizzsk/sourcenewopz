package com.didi.soda.customer.base.rxdux;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int mCacheSize;

    public LRUCache(int i) {
        super(16, 0.75f, true);
        this.mCacheSize = i;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() >= this.mCacheSize;
    }
}
