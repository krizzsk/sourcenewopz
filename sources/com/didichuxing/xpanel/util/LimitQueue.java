package com.didichuxing.xpanel.util;

import java.util.LinkedList;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f49587a;

    /* renamed from: b */
    private LinkedList<E> f49588b = new LinkedList<>();

    public LimitQueue(int i) {
        this.f49587a = i;
    }

    public void offer(E e) {
        if (this.f49588b.size() >= this.f49587a) {
            this.f49588b.poll();
        }
        this.f49588b.offerFirst(e);
    }

    public E get(int i) {
        if (i > size() || i < 0) {
            return null;
        }
        return this.f49588b.get(i);
    }

    public E getLast() {
        return this.f49588b.getLast();
    }

    public E getFirst() {
        return this.f49588b.getFirst();
    }

    public int getLimit() {
        return this.f49587a;
    }

    public int size() {
        return this.f49588b.size();
    }
}
