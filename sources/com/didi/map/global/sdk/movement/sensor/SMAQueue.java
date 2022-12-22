package com.didi.map.global.sdk.movement.sensor;

import java.util.LinkedList;

public class SMAQueue {

    /* renamed from: a */
    private final LinkedList f27746a = new LinkedList();

    public void clear() {
        this.f27746a.clear();
    }

    public boolean isEmpty() {
        return this.f27746a.isEmpty();
    }

    public void enQueue(Object obj) {
        this.f27746a.addLast(obj);
    }

    public Object deQueue() {
        if (!this.f27746a.isEmpty()) {
            return this.f27746a.removeFirst();
        }
        return null;
    }

    public int QueueLength() {
        return this.f27746a.size();
    }

    public Object QueuePeek() {
        return this.f27746a.getFirst();
    }

    public Object get(int i) {
        return this.f27746a.get(i);
    }
}
