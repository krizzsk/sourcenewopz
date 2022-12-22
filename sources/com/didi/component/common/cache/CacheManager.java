package com.didi.component.common.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheManager<T, F> {

    /* renamed from: a */
    private Map<T, F> f11484a;

    public void addCache(T t, F f) {
        if (t != null && f != null) {
            m7760a();
            this.f11484a.put(t, f);
        }
    }

    public F getCache(T t) {
        Map<T, F> map = this.f11484a;
        if (map == null || t == null) {
            return null;
        }
        return map.get(t);
    }

    public boolean hasCache(T t) {
        Map<T, F> map = this.f11484a;
        if (map == null || t == null) {
            return false;
        }
        return map.containsKey(t);
    }

    /* renamed from: a */
    private void m7760a() {
        if (this.f11484a == null) {
            this.f11484a = new HashMap();
        }
    }
}
