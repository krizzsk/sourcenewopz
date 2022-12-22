package com.didi.sdk.audiorecorder.utils.log;

/* renamed from: com.didi.sdk.audiorecorder.utils.log.a */
/* compiled from: RecoveryCoordinator */
final class C12125a {

    /* renamed from: a */
    private static final long f35602a = 20;

    /* renamed from: b */
    private static final long f35603b = 327680;

    /* renamed from: c */
    private static final long f35604c = -1;

    /* renamed from: d */
    private long f35605d = 20;

    /* renamed from: e */
    private long f35606e = -1;

    /* renamed from: f */
    private long f35607f = (System.currentTimeMillis() + m25206c());

    C12125a() {
    }

    /* renamed from: a */
    public boolean mo91281a() {
        long b = m25205b();
        if (b <= this.f35607f) {
            return true;
        }
        this.f35607f = b + m25206c();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91280a(long j) {
        this.f35606e = j;
    }

    /* renamed from: b */
    private long m25205b() {
        long j = this.f35606e;
        return j != -1 ? j : System.currentTimeMillis();
    }

    /* renamed from: c */
    private long m25206c() {
        long j = this.f35605d;
        if (j < f35603b) {
            this.f35605d = 4 * j;
        }
        return j;
    }
}
