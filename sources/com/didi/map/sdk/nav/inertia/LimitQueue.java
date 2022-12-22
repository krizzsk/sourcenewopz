package com.didi.map.sdk.nav.inertia;

import java.util.LinkedList;

public class LimitQueue<E> {

    /* renamed from: a */
    private int f28466a;

    /* renamed from: b */
    private LinkedList<E> f28467b = new LinkedList<>();

    public LimitQueue(int i) {
        this.f28466a = i;
    }

    public void offer(E e) {
        if (this.f28467b.size() >= this.f28466a) {
            this.f28467b.poll();
        }
        this.f28467b.offer(e);
    }

    public E get(int i) {
        return this.f28467b.get(i);
    }

    public E getLast() {
        if (this.f28467b.size() == 0) {
            return null;
        }
        return this.f28467b.getLast();
    }

    public void poll() {
        LinkedList<E> linkedList = this.f28467b;
        if (linkedList != null && linkedList.size() > 0) {
            this.f28467b.poll();
        }
    }

    public E getFirst() {
        return this.f28467b.getFirst();
    }

    public int getLimit() {
        return this.f28466a;
    }

    public void setLimitedSize(int i) {
        this.f28466a = i;
    }

    public int size() {
        return this.f28467b.size();
    }

    public void clear() {
        this.f28467b.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f28467b.size(); i++) {
            sb.append(this.f28467b.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }
}
