package com.didi.sdk.onehotpatch.gesture;

public class CircleQueue {
    private int capacity;
    private int head;

    /* renamed from: q */
    private float[] f36874q;
    private int tail;

    public CircleQueue() {
        this(400);
    }

    public CircleQueue(int i) {
        this.f36874q = null;
        this.head = 0;
        this.tail = 0;
        this.capacity = 0;
        this.capacity = i;
        this.f36874q = new float[i];
    }

    public boolean enqueue(float f) {
        if (isFull()) {
            dequeue();
        }
        float[] fArr = this.f36874q;
        int i = this.tail;
        fArr[i] = f;
        this.tail = (i + 1) % this.capacity;
        return false;
    }

    public float[] dequeueAll() {
        int queueLength = queueLength();
        float[] fArr = new float[queueLength];
        for (int i = 0; i < queueLength; i++) {
            fArr[i] = dequeue();
        }
        return fArr;
    }

    private float dequeue() {
        if (isNull()) {
            return Float.MIN_VALUE;
        }
        float[] fArr = this.f36874q;
        int i = this.head;
        float f = fArr[i];
        this.head = (i + 1) % this.capacity;
        return f;
    }

    public void clear() {
        this.head = 0;
        this.tail = 0;
    }

    private boolean isFull() {
        return (this.tail + 1) % this.capacity == this.head;
    }

    public boolean isNull() {
        return this.head == this.tail;
    }

    public int queueLength() {
        if (isNull()) {
            return 0;
        }
        if (isFull()) {
            return this.capacity - 1;
        }
        int i = this.tail;
        int i2 = this.head;
        if (i > i2) {
            return i - i2;
        }
        return this.capacity - (i2 - i);
    }
}
