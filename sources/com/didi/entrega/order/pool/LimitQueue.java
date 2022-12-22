package com.didi.entrega.order.pool;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f20912a;

    /* renamed from: b */
    private LinkedList<E> f20913b = new LinkedList<>();

    /* renamed from: c */
    private Comparator<E> f20914c;

    public LimitQueue(int i) {
        this.f20912a = i;
    }

    public void addComparator(Comparator<E> comparator) {
        this.f20914c = comparator;
    }

    public void clear() {
        this.f20913b.clear();
    }

    public E get(int i) {
        return this.f20913b.get(i);
    }

    public E getFirst() {
        return this.f20913b.getFirst();
    }

    public Iterator<E> getIterator() {
        LinkedList<E> linkedList = this.f20913b;
        if (linkedList != null) {
            return linkedList.iterator();
        }
        return null;
    }

    public E getLast() {
        return this.f20913b.getLast();
    }

    public int getLimitSize() {
        return this.f20912a;
    }

    public List<E> getList() {
        return new LinkedList(this.f20913b);
    }

    public void offer(E e) {
        synchronized (this.f20913b) {
            this.f20913b.add(e);
            if (this.f20914c != null) {
                Collections.sort(this.f20913b, this.f20914c);
            }
            if (this.f20913b.size() > this.f20912a) {
                this.f20913b.remove(getLast());
            }
        }
    }

    public int size() {
        return this.f20913b.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        Iterator it = this.f20913b.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }
}
