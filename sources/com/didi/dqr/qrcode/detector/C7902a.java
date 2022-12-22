package com.didi.dqr.qrcode.detector;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dqr.qrcode.detector.a */
/* compiled from: AlignmentPatternFinder */
final class C7902a {

    /* renamed from: a */
    private final BitMatrix f19072a;

    /* renamed from: b */
    private final List<AlignmentPattern> f19073b = new ArrayList(5);

    /* renamed from: c */
    private final int f19074c;

    /* renamed from: d */
    private final int f19075d;

    /* renamed from: e */
    private final int f19076e;

    /* renamed from: f */
    private final int f19077f;

    /* renamed from: g */
    private final float f19078g;

    /* renamed from: h */
    private final int[] f19079h;

    C7902a(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f) {
        this.f19072a = bitMatrix;
        this.f19074c = i;
        this.f19075d = i2;
        this.f19076e = i3;
        this.f19077f = i4;
        this.f19078g = f;
        this.f19079h = new int[3];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AlignmentPattern mo58645a() throws NotFoundException {
        AlignmentPattern a;
        AlignmentPattern a2;
        int i = this.f19074c;
        int i2 = this.f19077f;
        int i3 = this.f19076e + i;
        int i4 = this.f19075d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f19072a.get(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.f19072a.get(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 != 2) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else if (m14267a(iArr) && (a2 = m14266a(iArr, i6, i7)) != null) {
                    return a2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                }
                i7++;
            }
            if (m14267a(iArr) && (a = m14266a(iArr, i6, i3)) != null) {
                return a;
            }
        }
        if (!this.f19073b.isEmpty()) {
            return this.f19073b.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static float m14265a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    /* renamed from: a */
    private boolean m14267a(int[] iArr) {
        float f = this.f19078g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private float m14264a(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f19072a;
        int height = bitMatrix.getHeight();
        int[] iArr = this.f19079h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < height && bitMatrix.get(i2, i6) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i6++;
        }
        if (i6 == height || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i6 < height && !bitMatrix.get(i2, i6) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i6++;
        }
        if (iArr[2] <= i3 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 < i4 * 2 && m14267a(iArr)) {
            return m14265a(iArr, i6);
        }
        return Float.NaN;
    }

    /* renamed from: a */
    private AlignmentPattern m14266a(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float a = m14265a(iArr, i2);
        float a2 = m14264a(i, (int) a, iArr[1] * 2, i3);
        if (Float.isNaN(a2)) {
            return null;
        }
        float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (AlignmentPattern next : this.f19073b) {
            if (next.mo58607a(f, a2, a)) {
                return next.mo58608b(a2, a, f);
            }
        }
        this.f19073b.add(new AlignmentPattern(a, a2, f));
        return null;
    }
}
