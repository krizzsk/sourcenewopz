package com.didi.dqr.pdf417.encoder;

/* renamed from: com.didi.dqr.pdf417.encoder.a */
/* compiled from: BarcodeRow */
final class C7885a {

    /* renamed from: a */
    private final byte[] f18989a;

    /* renamed from: b */
    private int f18990b = 0;

    C7885a(int i) {
        this.f18989a = new byte[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58565a(int i, byte b) {
        this.f18989a[i] = b;
    }

    /* renamed from: a */
    private void m14175a(int i, boolean z) {
        this.f18989a[i] = z ? (byte) 1 : 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58566a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f18990b;
            this.f18990b = i3 + 1;
            m14175a(i3, z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo58567a(int i) {
        int length = this.f18989a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f18989a[i2 / i];
        }
        return bArr;
    }
}
