package com.didi.hawaii.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LoopQueue<T> {

    /* renamed from: a */
    private int f24195a;

    /* renamed from: b */
    private int f24196b;

    /* renamed from: c */
    private Queue<T> f24197c;

    /* renamed from: d */
    private int f24198d;

    public LoopQueue() {
        this.f24195a = 20;
        this.f24198d = 0;
        this.f24196b = 20;
        this.f24197c = new LinkedList();
    }

    public LoopQueue(T t) {
        this();
        this.f24197c.offer(t);
        this.f24198d++;
    }

    public LoopQueue(int i) {
        this();
        this.f24196b = i;
    }

    public LoopQueue(T t, int i) {
        this(t);
        this.f24196b = i;
    }

    public synchronized int size() {
        if (isEmpty()) {
            return 0;
        }
        return this.f24197c.size();
    }

    public synchronized void add(T t) {
        if (this.f24198d >= this.f24196b) {
            this.f24197c.poll();
            this.f24197c.offer(t);
            return;
        }
        this.f24197c.offer(t);
        this.f24198d++;
    }

    public synchronized boolean isEmpty() {
        return this.f24198d == 0;
    }

    public synchronized void clear() {
        this.f24197c.clear();
        this.f24198d = 0;
    }

    public synchronized List<T> getNowQueue() {
        return new ArrayList(this.f24197c);
    }
}
