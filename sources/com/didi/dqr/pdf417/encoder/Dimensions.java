package com.didi.dqr.pdf417.encoder;

public final class Dimensions {

    /* renamed from: a */
    private final int f18971a;

    /* renamed from: b */
    private final int f18972b;

    /* renamed from: c */
    private final int f18973c;

    /* renamed from: d */
    private final int f18974d;

    public Dimensions(int i, int i2, int i3, int i4) {
        this.f18971a = i;
        this.f18972b = i2;
        this.f18973c = i3;
        this.f18974d = i4;
    }

    public int getMinCols() {
        return this.f18971a;
    }

    public int getMaxCols() {
        return this.f18972b;
    }

    public int getMinRows() {
        return this.f18973c;
    }

    public int getMaxRows() {
        return this.f18974d;
    }
}
