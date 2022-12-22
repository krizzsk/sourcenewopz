package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BitmapCache {

    /* renamed from: a */
    private Cache<String, Bitmap> f24457a;

    public BitmapCache(int i) {
        this.f24457a = new Cache<>(i);
    }

    public void clear() {
        this.f24457a.clear();
    }

    public void put(String str, Bitmap bitmap) {
        this.f24457a.put(str, bitmap);
    }

    public Bitmap get(String str) {
        return this.f24457a.get(str);
    }

    public Bitmap remove(String str) {
        return this.f24457a.remove(str);
    }

    static class BitmapInfo {
        Bitmap bitMap = null;
        long ltimeSpan = 0;

        BitmapInfo() {
        }
    }

    static class Cache<K, V> {
        private static final float hashTableLoadFactor = 0.75f;
        /* access modifiers changed from: private */
        public int cacheSize;
        byte[] lockStruct = new byte[0];
        private LinkedHashMap<K, V> map;

        public Cache(int i) {
            this.cacheSize = i;
            this.map = new LinkedHashMap<K, V>(((int) Math.ceil((double) (((float) i) / 0.75f))) + 1, 0.75f, true) {
                private static final long serialVersionUID = 1;

                /* access modifiers changed from: protected */
                public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    return size() > Cache.this.cacheSize;
                }
            };
        }

        public V get(K k) {
            V v;
            synchronized (this.lockStruct) {
                v = this.map.get(k);
            }
            return v;
        }

        public void put(K k, V v) {
            synchronized (this.lockStruct) {
                this.map.put(k, v);
            }
        }

        public V remove(K k) {
            V remove;
            synchronized (this.lockStruct) {
                remove = this.map.remove(k);
            }
            return remove;
        }

        public void clear() {
            synchronized (this.lockStruct) {
                this.map.clear();
            }
        }

        public synchronized int usedEntries() {
            return this.map.size();
        }

        public synchronized Collection<Map.Entry<K, V>> getAll() {
            return new ArrayList(this.map.entrySet());
        }
    }
}
