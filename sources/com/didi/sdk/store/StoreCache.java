package com.didi.sdk.store;

import androidx.collection.LruCache;

class StoreCache<T> {

    /* renamed from: a */
    public static final int f37542a = -1;

    /* renamed from: b */
    public static final int f37543b = -2;

    /* renamed from: c */
    private static final int f37544c = 32;

    /* renamed from: d */
    private LruCache<String, StoreCache<T>.CacheItem> f37545d = new LruCache<>(32);

    /* renamed from: a */
    public void mo96566a(String str, T t, long j) {
        CacheItem cacheItem = new CacheItem(t, j);
        synchronized (this.f37545d) {
            this.f37545d.put(str, cacheItem);
        }
    }

    /* renamed from: a */
    public void mo96565a(String str) {
        synchronized (this.f37545d) {
            this.f37545d.remove(str);
        }
    }

    /* renamed from: b */
    public T mo96567b(String str) {
        StoreCache<T>.CacheItem e = m26663e(str);
        if (e == null) {
            return null;
        }
        return e.getValue();
    }

    /* renamed from: c */
    public boolean mo96568c(String str) {
        StoreCache<T>.CacheItem e = m26663e(str);
        if (e == null) {
            return true;
        }
        return e.isExpired();
    }

    /* renamed from: d */
    public boolean mo96569d(String str) {
        return this.f37545d.snapshot().keySet().contains(str);
    }

    /* renamed from: e */
    private StoreCache<T>.CacheItem m26663e(String str) {
        StoreCache<T>.CacheItem cacheItem;
        synchronized (this.f37545d) {
            cacheItem = this.f37545d.get(str);
        }
        return cacheItem;
    }

    private class CacheItem {
        private long mDuration;
        private long mStartTimestamp = System.currentTimeMillis();
        private T mValue;

        public CacheItem(T t, long j) {
            this.mValue = t;
            this.mDuration = j;
        }

        public T getValue() {
            return this.mValue;
        }

        public boolean isExpired() {
            long j = this.mDuration;
            if (j == -1) {
                return false;
            }
            if (j != -2 && System.currentTimeMillis() - this.mStartTimestamp <= this.mDuration) {
                return false;
            }
            return true;
        }
    }
}
