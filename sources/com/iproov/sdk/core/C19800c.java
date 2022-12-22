package com.iproov.sdk.core;

/* renamed from: com.iproov.sdk.core.c */
/* compiled from: SupplementaryImageryManager */
class C19800c {

    /* renamed from: a */
    private int f54093a = 0;

    /* renamed from: b */
    private int f54094b = 0;

    /* renamed from: c */
    private Long f54095c;

    /* renamed from: d */
    private boolean f54096d = false;

    /* renamed from: e */
    private volatile boolean f54097e = false;

    C19800c() {
    }

    /* renamed from: a */
    public void mo161966a() {
        this.f54097e = true;
    }

    /* renamed from: a */
    public void mo161967a(boolean z) {
        this.f54096d = z;
    }

    /* renamed from: b */
    public synchronized boolean mo161968b() {
        Long l;
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f54096d || (((l = this.f54095c) != null && l.longValue() >= currentTimeMillis) || this.f54097e || (i = this.f54094b) >= 10)) {
            return false;
        }
        this.f54093a++;
        this.f54094b = i + 1;
        this.f54095c = Long.valueOf(currentTimeMillis + 1000);
        return true;
    }

    /* renamed from: c */
    public synchronized boolean mo161969c() {
        int i;
        if (!this.f54096d || (i = this.f54093a) <= 0) {
            return false;
        }
        this.f54093a = i - 1;
        return true;
    }
}
