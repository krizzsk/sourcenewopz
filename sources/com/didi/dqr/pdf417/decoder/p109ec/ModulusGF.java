package com.didi.dqr.pdf417.decoder.p109ec;

/* renamed from: com.didi.dqr.pdf417.decoder.ec.ModulusGF */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(929, 3);

    /* renamed from: a */
    private final int[] f18942a;

    /* renamed from: b */
    private final int[] f18943b;

    /* renamed from: c */
    private final C7881a f18944c;

    /* renamed from: d */
    private final C7881a f18945d;

    /* renamed from: e */
    private final int f18946e;

    private ModulusGF(int i, int i2) {
        this.f18946e = i;
        this.f18942a = new int[i];
        this.f18943b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f18942a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f18943b[this.f18942a[i5]] = i5;
        }
        this.f18944c = new C7881a(this, new int[]{0});
        this.f18945d = new C7881a(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7881a mo58516a() {
        return this.f18944c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C7881a mo58520b() {
        return this.f18945d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C7881a mo58517a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f18944c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C7881a(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58519b(int i, int i2) {
        return (i + i2) % this.f18946e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58523c(int i, int i2) {
        int i3 = this.f18946e;
        return ((i + i3) - i2) % i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58515a(int i) {
        return this.f18942a[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58518b(int i) {
        if (i != 0) {
            return this.f18943b[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58522c(int i) {
        if (i != 0) {
            return this.f18942a[(this.f18946e - this.f18943b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo58524d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f18942a;
        int[] iArr2 = this.f18943b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f18946e - 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58521c() {
        return this.f18946e;
    }
}
