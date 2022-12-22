package com.didichuxing.omega.sdk.common.utils;

import java.util.Collection;
import java.util.LinkedList;

public class BoundedLinkedQueue<E> extends LinkedList<E> {
    private final int maxSize;

    public BoundedLinkedQueue(int i) {
        this.maxSize = i;
    }

    public boolean add(E e) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        return super.add(e);
    }

    public void add(int i, E e) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        int size = (size() + collection.size()) - this.maxSize;
        if (size > 0) {
            removeRange(0, size);
        }
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void addFirst(E e) {
        throw new UnsupportedOperationException();
    }

    public void addLast(E e) {
        add(e);
    }

    public E getLast() {
        try {
            return super.getLast();
        } catch (Throwable unused) {
            return null;
        }
    }
}
