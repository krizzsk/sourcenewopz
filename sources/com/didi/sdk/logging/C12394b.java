package com.didi.sdk.logging;

/* renamed from: com.didi.sdk.logging.b */
/* compiled from: DefaultInvocationGate */
class C12394b implements InvocationGate {

    /* renamed from: a */
    static final int f36519a = 2;

    /* renamed from: b */
    static final int f36520b = 15;

    /* renamed from: e */
    private static final int f36521e = 65535;

    /* renamed from: h */
    private static final long f36522h = 100;

    /* renamed from: i */
    private static final long f36523i = 800;

    /* renamed from: c */
    long f36524c;

    /* renamed from: d */
    long f36525d;

    /* renamed from: f */
    private volatile long f36526f;

    /* renamed from: g */
    private long f36527g;

    /* renamed from: j */
    private long f36528j;

    /* renamed from: k */
    private long f36529k;

    C12394b() {
        this(100, 800, System.currentTimeMillis());
    }

    C12394b(long j, long j2, long j3) {
        this.f36526f = 15;
        this.f36527g = 0;
        this.f36528j = j;
        this.f36529k = j2;
        this.f36524c = j + j3;
        this.f36525d = j3 + j2;
    }

    public final boolean isTooSoon(long j) {
        long j2 = this.f36527g;
        this.f36527g = 1 + j2;
        boolean z = (j2 & this.f36526f) == this.f36526f;
        if (z) {
            if (j < this.f36524c) {
                m25883c();
            }
            m25882a(j);
        } else if (j > this.f36525d) {
            m25884d();
            m25882a(j);
            return false;
        }
        return !z;
    }

    /* renamed from: a */
    private void m25882a(long j) {
        this.f36524c = this.f36528j + j;
        this.f36525d = j + this.f36529k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo92600a() {
        return this.f36526f;
    }

    /* renamed from: c */
    private void m25883c() {
        if (this.f36526f < 65535) {
            this.f36526f = (this.f36526f << 1) | 1;
        }
    }

    /* renamed from: d */
    private void m25884d() {
        this.f36526f >>>= 2;
    }

    /* renamed from: b */
    public long mo92601b() {
        return this.f36527g;
    }
}
