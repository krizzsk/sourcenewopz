package com.didi.component.common.cache;

public class CacheStore {

    /* renamed from: a */
    private static CacheStore f11485a;

    /* renamed from: b */
    private CacheManager<String, Object> f11486b = new CacheManager<>();

    private CacheStore() {
    }

    public static CacheStore getInstance() {
        if (f11485a == null) {
            synchronized (CacheManager.class) {
                if (f11485a == null) {
                    f11485a = new CacheStore();
                }
            }
        }
        return f11485a;
    }

    public <T> T getCache(String str, T t) {
        T cache = this.f11486b.getCache(str);
        return cache != null ? cache : t;
    }

    public <T> void addCache(String str, T t) {
        this.f11486b.addCache(str, t);
    }
}
