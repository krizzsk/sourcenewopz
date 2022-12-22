package com.didi.entrega.order.pool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LimitMap<K, E> {

    /* renamed from: a */
    private int f20909a;

    /* renamed from: b */
    private LinkedHashMap<K, E> f20910b = new LinkedHashMap<>();

    /* renamed from: c */
    private Comparator<Map.Entry<K, E>> f20911c;

    public LimitMap(int i) {
        this.f20909a = i;
    }

    public void addComparator(Comparator<Map.Entry<K, E>> comparator) {
        this.f20911c = comparator;
    }

    public Comparator<Map.Entry<K, E>> getComparator() {
        return this.f20911c;
    }

    public void clear() {
        this.f20910b.clear();
    }

    public E get(K k) {
        return this.f20910b.get(k);
    }

    public int size() {
        return this.f20910b.size();
    }

    public int getLimitSize() {
        return this.f20909a;
    }

    public Iterator<Map.Entry<K, E>> getIterator() {
        return this.f20910b.entrySet().iterator();
    }

    public Set<K> getKeySet() {
        return this.f20910b.keySet();
    }

    public Set<Map.Entry<K, E>> getEntrySet() {
        return this.f20910b.entrySet();
    }

    public List<E> getList() {
        return new ArrayList(this.f20910b.values());
    }

    public synchronized void offerAndSort(K k, E e) {
        offer(k, e);
    }

    public void offer(K k, E e) {
        this.f20910b.put(k, e);
    }
}
