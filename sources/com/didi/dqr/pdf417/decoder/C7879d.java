package com.didi.dqr.pdf417.decoder;

/* renamed from: com.didi.dqr.pdf417.decoder.d */
/* compiled from: Codeword */
final class C7879d {

    /* renamed from: a */
    private static final int f18930a = -1;

    /* renamed from: b */
    private final int f18931b;

    /* renamed from: c */
    private final int f18932c;

    /* renamed from: d */
    private final int f18933d;

    /* renamed from: e */
    private final int f18934e;

    /* renamed from: f */
    private int f18935f = -1;

    C7879d(int i, int i2, int i3, int i4) {
        this.f18931b = i;
        this.f18932c = i2;
        this.f18933d = i3;
        this.f18934e = i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo58494a() {
        return mo58495a(this.f18935f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo58495a(int i) {
        return i != -1 && this.f18933d == (i % 3) * 3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo58496b() {
        this.f18935f = ((this.f18934e / 30) * 3) + (this.f18933d / 3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58498c() {
        return this.f18932c - this.f18931b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo58499d() {
        return this.f18931b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo58500e() {
        return this.f18932c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo58501f() {
        return this.f18933d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo58502g() {
        return this.f18934e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo58503h() {
        return this.f18935f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo58497b(int i) {
        this.f18935f = i;
    }

    public String toString() {
        return this.f18935f + "|" + this.f18934e;
    }
}
