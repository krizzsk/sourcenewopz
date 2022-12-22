package com.didi.component.core;

import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.didi.component.core.a */
/* compiled from: IndexAllocator */
class C5348a<K> {

    /* renamed from: a */
    private WeakHashMap<K, Integer> f12750a = new WeakHashMap<>();

    C5348a() {
    }

    /* renamed from: a */
    public synchronized int mo48165a(K k, int i, int i2) {
        if (k == null) {
            return -1;
        }
        if (this.f12750a.containsKey(k)) {
            Integer num = this.f12750a.get(k);
            if (num != null) {
                return num.intValue();
            }
            this.f12750a.remove(k);
        }
        while (i < i2) {
            if (this.f12750a.containsValue(Integer.valueOf(i))) {
                i++;
            } else {
                this.f12750a.put(k, Integer.valueOf(i));
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public synchronized K mo48166a(int i) {
        if (!this.f12750a.containsValue(Integer.valueOf(i))) {
            return null;
        }
        for (Map.Entry next : this.f12750a.entrySet()) {
            Integer num = (Integer) next.getValue();
            if (num != null) {
                if (num.intValue() == i) {
                    return next.getKey();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void mo48167a(K k) {
        if (k != null) {
            this.f12750a.remove(k);
        }
    }
}
