package com.didi.dqr.common.reedsolomon;

import org.osgi.framework.VersionRange;

public final class GenericGF {
    public static final GenericGF DATA_MATRIX_FIELD_256 = new GenericGF(301, 256, 1);
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);

    /* renamed from: a */
    private final int[] f18575a;

    /* renamed from: b */
    private final int[] f18576b;

    /* renamed from: c */
    private final C7834a f18577c;

    /* renamed from: d */
    private final C7834a f18578d;

    /* renamed from: e */
    private final int f18579e;

    /* renamed from: f */
    private final int f18580f;

    /* renamed from: g */
    private final int f18581g;

    /* renamed from: b */
    static int m13737b(int i, int i2) {
        return i ^ i2;
    }

    public GenericGF(int i, int i2, int i3) {
        this.f18580f = i;
        this.f18579e = i2;
        this.f18581g = i3;
        this.f18575a = new int[i2];
        this.f18576b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f18575a[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f18576b[this.f18575a[i6]] = i6;
        }
        this.f18577c = new C7834a(this, new int[]{0});
        this.f18578d = new C7834a(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7834a mo58280a() {
        return this.f18577c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C7834a mo58283b() {
        return this.f18578d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7834a mo58281a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f18577c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C7834a(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58279a(int i) {
        return this.f18575a[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58282b(int i) {
        if (i != 0) {
            return this.f18576b[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58284c(int i) {
        if (i != 0) {
            return this.f18575a[(this.f18579e - this.f18576b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58285c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f18575a;
        int[] iArr2 = this.f18576b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f18579e - 1)];
    }

    public int getSize() {
        return this.f18579e;
    }

    public int getGeneratorBase() {
        return this.f18581g;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f18580f) + ',' + this.f18579e + VersionRange.RIGHT_OPEN;
    }
}
