package com.airbnb.lottie.utils;

public class MeanCalculator {

    /* renamed from: a */
    private float f1692a;

    /* renamed from: b */
    private int f1693b;

    public void add(float f) {
        float f2 = this.f1692a + f;
        this.f1692a = f2;
        int i = this.f1693b + 1;
        this.f1693b = i;
        if (i == Integer.MAX_VALUE) {
            this.f1692a = f2 / 2.0f;
            this.f1693b = i / 2;
        }
    }

    public float getMean() {
        int i = this.f1693b;
        if (i == 0) {
            return 0.0f;
        }
        return this.f1692a / ((float) i);
    }
}
