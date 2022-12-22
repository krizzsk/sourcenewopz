package com.didi.sdk.logging;

/* renamed from: com.didi.sdk.logging.e */
/* compiled from: RecoveryCoordinator */
class C12397e {

    /* renamed from: a */
    public static final long f36542a = 20;

    /* renamed from: b */
    static long f36543b = 327680;

    /* renamed from: e */
    private static long f36544e = -1;

    /* renamed from: c */
    long f36545c = (System.currentTimeMillis() + m25897c());

    /* renamed from: d */
    private long f36546d = 20;

    /* renamed from: f */
    private long f36547f = f36544e;

    C12397e() {
    }

    /* renamed from: a */
    public boolean mo92606a() {
        long b = m25896b();
        if (b <= this.f36545c) {
            return true;
        }
        this.f36545c = b + m25897c();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo92605a(long j) {
        this.f36547f = j;
    }

    /* renamed from: b */
    private long m25896b() {
        long j = this.f36547f;
        if (j != f36544e) {
            return j;
        }
        return System.currentTimeMillis();
    }

    /* renamed from: c */
    private long m25897c() {
        long j = this.f36546d;
        if (j < f36543b) {
            this.f36546d = 4 * j;
        }
        return j;
    }
}
