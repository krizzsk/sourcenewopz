package com.didi.dqr.oned.rss.expanded.decoders;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.m */
/* compiled from: DecodedInformation */
final class C7870m extends C7872o {

    /* renamed from: a */
    private final String f18849a;

    /* renamed from: b */
    private final int f18850b;

    /* renamed from: c */
    private final boolean f18851c;

    C7870m(int i, String str) {
        super(i);
        this.f18849a = str;
        this.f18851c = false;
        this.f18850b = 0;
    }

    C7870m(int i, String str, int i2) {
        super(i);
        this.f18851c = true;
        this.f18850b = i2;
        this.f18849a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo58440a() {
        return this.f18849a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo58441b() {
        return this.f18851c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo58442c() {
        return this.f18850b;
    }
}
