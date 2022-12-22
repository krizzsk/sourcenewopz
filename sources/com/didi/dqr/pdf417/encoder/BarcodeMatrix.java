package com.didi.dqr.pdf417.encoder;

import java.lang.reflect.Array;

public final class BarcodeMatrix {

    /* renamed from: a */
    private final C7885a[] f18967a;

    /* renamed from: b */
    private int f18968b;

    /* renamed from: c */
    private final int f18969c;

    /* renamed from: d */
    private final int f18970d;

    BarcodeMatrix(int i, int i2) {
        C7885a[] aVarArr = new C7885a[i];
        this.f18967a = aVarArr;
        int length = aVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f18967a[i3] = new C7885a(((i2 + 4) * 17) + 1);
        }
        this.f18970d = i2 * 17;
        this.f18969c = i;
        this.f18968b = -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58551a(int i, int i2, byte b) {
        this.f18967a[i2].mo58565a(i, b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58550a() {
        this.f18968b++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C7885a mo58552b() {
        return this.f18967a[this.f18968b];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = this.f18970d * i;
        iArr[0] = this.f18969c * i2;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        int i3 = this.f18969c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f18967a[i4 / i2].mo58567a(i);
        }
        return bArr;
    }
}
