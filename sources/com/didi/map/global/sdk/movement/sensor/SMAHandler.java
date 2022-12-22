package com.didi.map.global.sdk.movement.sensor;

public class SMAHandler {

    /* renamed from: a */
    private final SMAQueue f27744a;

    /* renamed from: b */
    private final int f27745b;

    public SMAHandler(int i) {
        this.f27745b = i;
        if (i >= 1) {
            this.f27744a = new SMAQueue();
            return;
        }
        throw new IllegalArgumentException("SMA Queue's length < 1");
    }

    public float handleValues(float f) {
        return m19878a(f, this.f27744a);
    }

    public void destroy() {
        this.f27744a.clear();
    }

    /* renamed from: a */
    private float m19878a(float f, SMAQueue sMAQueue) {
        float f2 = 0.0f;
        if (sMAQueue == null) {
            return 0.0f;
        }
        if (sMAQueue.isEmpty()) {
            sMAQueue.enQueue(Float.valueOf(f));
            return f;
        }
        sMAQueue.enQueue(Float.valueOf(f));
        if (sMAQueue.QueueLength() > this.f27745b) {
            sMAQueue.deQueue();
        }
        int QueueLength = sMAQueue.QueueLength();
        for (int i = 0; i < QueueLength; i++) {
            f2 += ((Float) sMAQueue.get(i)).floatValue();
        }
        return f2 / ((float) QueueLength);
    }
}
