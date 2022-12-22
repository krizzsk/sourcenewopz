package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.n */
/* compiled from: DecodedNumeric */
final class C7871n extends C7872o {

    /* renamed from: a */
    static final int f18852a = 10;

    /* renamed from: b */
    private final int f18853b;

    /* renamed from: c */
    private final int f18854c;

    C7871n(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f18853b = i2;
        this.f18854c = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58443a() {
        return this.f18853b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo58444b() {
        return this.f18854c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58445c() {
        return (this.f18853b * 10) + this.f18854c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo58446d() {
        return this.f18853b == 10;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo58447e() {
        return this.f18854c == 10;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo58448f() {
        return this.f18853b == 10 || this.f18854c == 10;
    }
}
