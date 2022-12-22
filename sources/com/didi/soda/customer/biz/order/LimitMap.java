package com.didi.soda.customer.biz.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LimitMap<K, E> {

    /* renamed from: a */
    private int f40407a;

    /* renamed from: b */
    private LinkedHashMap<K, E> f40408b = new LinkedHashMap<>();

    /* renamed from: c */
    private Comparator<Map.Entry<K, E>> f40409c;

    public LimitMap(int i) {
        this.f40407a = i;
    }

    public void addComparator(Comparator<Map.Entry<K, E>> comparator) {
        this.f40409c = comparator;
    }

    public Comparator<Map.Entry<K, E>> getComparator() {
        return this.f40409c;
    }

    public void clear() {
        this.f40408b.clear();
    }

    public E get(K k) {
        return this.f40408b.get(k);
    }

    public int size() {
        return this.f40408b.size();
    }

    public int getLimitSize() {
        return this.f40407a;
    }

    public Iterator<Map.Entry<K, E>> getIterator() {
        return this.f40408b.entrySet().iterator();
    }

    public Set<K> getKeySet() {
        return this.f40408b.keySet();
    }

    public Set<Map.Entry<K, E>> getEntrySet() {
        return this.f40408b.entrySet();
    }

    public List<E> getList() {
        return new ArrayList(this.f40408b.values());
    }

    public synchronized void offerAndSort(K k, E e) {
        offer(k, e);
        resort();
    }

    public void offer(K k, E e) {
        this.f40408b.put(k, e);
    }

    public void resort() {
        LinkedList<Map.Entry> linkedList = new LinkedList<>(getEntrySet());
        Collections.sort(linkedList, this.f40409c);
        this.f40408b.clear();
        for (Map.Entry entry : linkedList) {
            if (this.f40408b.size() < this.f40407a) {
                this.f40408b.put(entry.getKey(), entry.getValue());
            } else {
                return;
            }
        }
    }
}
