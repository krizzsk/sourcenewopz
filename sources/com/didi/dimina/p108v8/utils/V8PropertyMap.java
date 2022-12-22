package com.didi.dimina.p108v8.utils;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/* renamed from: com.didi.dimina.v8.utils.V8PropertyMap */
class V8PropertyMap<V> implements Map<String, V> {
    private Hashtable<String, V> map = new Hashtable<>();
    private Set<String> nulls = new HashSet();

    V8PropertyMap() {
    }

    public int size() {
        return this.map.size() + this.nulls.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty() && this.nulls.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj) || this.nulls.contains(obj);
    }

    public boolean containsValue(Object obj) {
        if (obj == null && !this.nulls.isEmpty()) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return this.map.containsValue(obj);
    }

    public V get(Object obj) {
        if (this.nulls.contains(obj)) {
            return null;
        }
        return this.map.get(obj);
    }

    public V put(String str, V v) {
        if (v == null) {
            if (this.map.containsKey(str)) {
                this.map.remove(str);
            }
            this.nulls.add(str);
            return null;
        }
        if (this.nulls.contains(str)) {
            this.nulls.remove(str);
        }
        return this.map.put(str, v);
    }

    public V remove(Object obj) {
        if (!this.nulls.contains(obj)) {
            return this.map.remove(obj);
        }
        this.nulls.remove(obj);
        return null;
    }

    public void putAll(Map<? extends String, ? extends V> map2) {
        for (Map.Entry next : map2.entrySet()) {
            put((String) next.getKey(), next.getValue());
        }
    }

    public void clear() {
        this.map.clear();
        this.nulls.clear();
    }

    public Set<String> keySet() {
        HashSet hashSet = new HashSet(this.map.keySet());
        hashSet.addAll(this.nulls);
        return hashSet;
    }

    public Collection<V> values() {
        ArrayList arrayList = new ArrayList(this.map.values());
        for (int i = 0; i < this.nulls.size(); i++) {
            arrayList.add((Object) null);
        }
        return arrayList;
    }

    public Set<Map.Entry<String, V>> entrySet() {
        HashSet hashSet = new HashSet(this.map.entrySet());
        for (String simpleEntry : this.nulls) {
            hashSet.add(new AbstractMap.SimpleEntry(simpleEntry, (Object) null));
        }
        return hashSet;
    }
}
