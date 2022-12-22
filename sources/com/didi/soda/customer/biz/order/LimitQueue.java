package com.didi.soda.customer.biz.order;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f40410a;

    /* renamed from: b */
    private LinkedList<E> f40411b = new LinkedList<>();

    /* renamed from: c */
    private Comparator<E> f40412c;

    public LimitQueue(int i) {
        this.f40410a = i;
    }

    public void addComparator(Comparator<E> comparator) {
        this.f40412c = comparator;
    }

    public void clear() {
        this.f40411b.clear();
    }

    public E get(int i) {
        return this.f40411b.get(i);
    }

    public E getFirst() {
        return this.f40411b.getFirst();
    }

    public Iterator<E> getIterator() {
        LinkedList<E> linkedList = this.f40411b;
        if (linkedList != null) {
            return linkedList.iterator();
        }
        return null;
    }

    public E getLast() {
        return this.f40411b.getLast();
    }

    public int getLimitSize() {
        return this.f40410a;
    }

    public List<E> getList() {
        return new LinkedList(this.f40411b);
    }

    public void offer(E e) {
        synchronized (this.f40411b) {
            this.f40411b.add(e);
            if (this.f40412c != null) {
                Collections.sort(this.f40411b, this.f40412c);
            }
            if (this.f40411b.size() > this.f40410a) {
                this.f40411b.remove(getLast());
            }
        }
    }

    public int size() {
        return this.f40411b.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        Iterator it = this.f40411b.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }
}
