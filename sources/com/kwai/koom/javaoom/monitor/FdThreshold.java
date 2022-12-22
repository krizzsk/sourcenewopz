package com.kwai.koom.javaoom.monitor;

public class FdThreshold implements Threshold {

    /* renamed from: a */
    private static final int f55617a = 15000;

    /* renamed from: b */
    private static final int f55618b = 3;

    /* renamed from: c */
    private static final int f55619c = 800;

    public boolean ascending() {
        return true;
    }

    public float maxValue() {
        return 0.0f;
    }

    public int overTimes() {
        return 3;
    }

    public int pollInterval() {
        return 15000;
    }

    public float value() {
        return 800.0f;
    }

    public ThresholdValueType valueType() {
        return ThresholdValueType.COUNT;
    }
}
