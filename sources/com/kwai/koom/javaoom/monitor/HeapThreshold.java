package com.kwai.koom.javaoom.monitor;

public class HeapThreshold implements Threshold {

    /* renamed from: a */
    private float f55628a;

    /* renamed from: b */
    private float f55629b;

    /* renamed from: c */
    private int f55630c;

    /* renamed from: d */
    private int f55631d;

    public boolean ascending() {
        return true;
    }

    public HeapThreshold(float f, float f2, int i, int i2) {
        this.f55628a = f;
        this.f55629b = f2;
        this.f55630c = i;
        this.f55631d = i2;
    }

    public float value() {
        return this.f55628a;
    }

    public float maxValue() {
        return this.f55629b;
    }

    public int overTimes() {
        return this.f55630c;
    }

    public final ThresholdValueType valueType() {
        return ThresholdValueType.PERCENT;
    }

    public int pollInterval() {
        return this.f55631d;
    }
}
