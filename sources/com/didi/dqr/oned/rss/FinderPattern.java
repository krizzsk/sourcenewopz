package com.didi.dqr.oned.rss;

import com.didi.dqr.ResultPoint;

public final class FinderPattern {

    /* renamed from: a */
    private final int f18788a;

    /* renamed from: b */
    private final int[] f18789b;

    /* renamed from: c */
    private final ResultPoint[] f18790c;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.f18788a = i;
        this.f18789b = iArr;
        float f = (float) i4;
        this.f18790c = new ResultPoint[]{new ResultPoint((float) i2, f), new ResultPoint((float) i3, f)};
    }

    public int getValue() {
        return this.f18788a;
    }

    public int[] getStartEnd() {
        return this.f18789b;
    }

    public ResultPoint[] getResultPoints() {
        return this.f18790c;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof FinderPattern) && this.f18788a == ((FinderPattern) obj).f18788a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f18788a;
    }
}
