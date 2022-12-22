package com.didi.dqr.oned.rss;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.detector.MathUtils;
import com.didi.dqr.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {

    /* renamed from: a */
    private static final float f18776a = 0.2f;

    /* renamed from: b */
    private static final float f18777b = 0.45f;

    /* renamed from: c */
    private static final float f18778c = 0.7916667f;

    /* renamed from: d */
    private static final float f18779d = 0.89285713f;

    /* renamed from: e */
    private final int[] f18780e = new int[4];

    /* renamed from: f */
    private final int[] f18781f;

    /* renamed from: g */
    private final float[] f18782g;

    /* renamed from: h */
    private final float[] f18783h;

    /* renamed from: i */
    private final int[] f18784i;

    /* renamed from: j */
    private final int[] f18785j;

    protected AbstractRSSReader() {
        int[] iArr = new int[8];
        this.f18781f = iArr;
        this.f18782g = new float[4];
        this.f18783h = new float[4];
        this.f18784i = new int[(iArr.length / 2)];
        this.f18785j = new int[(iArr.length / 2)];
    }

    /* access modifiers changed from: protected */
    public final int[] getDecodeFinderCounters() {
        return this.f18780e;
    }

    /* access modifiers changed from: protected */
    public final int[] getDataCharacterCounters() {
        return this.f18781f;
    }

    /* access modifiers changed from: protected */
    public final float[] getOddRoundingErrors() {
        return this.f18782g;
    }

    /* access modifiers changed from: protected */
    public final float[] getEvenRoundingErrors() {
        return this.f18783h;
    }

    /* access modifiers changed from: protected */
    public final int[] getOddCounts() {
        return this.f18784i;
    }

    /* access modifiers changed from: protected */
    public final int[] getEvenCounts() {
        return this.f18785j;
    }

    protected static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (patternMatchVariance(iArr, iArr2[i], f18777b) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Deprecated
    protected static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    protected static void increment(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void decrement(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean isFinderPattern(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f < f18778c || f > f18779d) {
            return false;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 : iArr) {
            if (i4 > i3) {
                i3 = i4;
            }
            if (i4 < i2) {
                i2 = i4;
            }
        }
        if (i3 < i2 * 10) {
            return true;
        }
        return false;
    }
}
