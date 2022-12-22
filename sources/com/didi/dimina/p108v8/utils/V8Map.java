package com.didi.dimina.p108v8.utils;

import com.didi.dimina.p108v8.Releasable;
import com.didi.dimina.p108v8.V8Value;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.didi.dimina.v8.utils.V8Map */
public class V8Map<V> implements Releasable, Map<V8Value, V> {
    private Map<V8Value, V> map = new HashMap();
    private Map<V8Value, V8Value> twinMap = new HashMap();

    public void close() {
        clear();
    }

    @Deprecated
    public void release() {
        close();
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public V get(Object obj) {
        return this.map.get(obj);
    }

    public V put(V8Value v8Value, V v) {
        remove(v8Value);
        V8Value twin = v8Value.twin();
        this.twinMap.put(twin, twin);
        return this.map.put(twin, v);
    }

    public V remove(Object obj) {
        V remove = this.map.remove(obj);
        V8Value remove2 = this.twinMap.remove(obj);
        if (remove2 != null) {
            remove2.close();
        }
        return remove;
    }

    public void putAll(Map<? extends V8Value, ? extends V> map2) {
        for (Map.Entry next : map2.entrySet()) {
            put((V8Value) next.getKey(), next.getValue());
        }
    }

    public void clear() {
        this.map.clear();
        for (V8Value close : this.twinMap.keySet()) {
            close.close();
        }
        this.twinMap.clear();
    }

    public Set<V8Value> keySet() {
        return this.map.keySet();
    }

    public Collection<V> values() {
        return this.map.values();
    }

    public Set<Map.Entry<V8Value, V>> entrySet() {
        return this.map.entrySet();
    }
}
