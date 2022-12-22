package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.cc */
public final class C18482cc extends C18481cb {

    /* renamed from: a */
    private final C18481cb f53168a;

    /* renamed from: b */
    private final long f53169b;

    /* renamed from: c */
    private final long f53170c;

    public C18482cc(C18481cb cbVar, long j, long j2) {
        this.f53168a = cbVar;
        long a = m37898a(j);
        this.f53169b = a;
        this.f53170c = m37898a(a + j2);
    }

    /* renamed from: a */
    private final long m37898a(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.f53168a.mo148938a() ? this.f53168a.mo148938a() : j;
    }

    /* renamed from: a */
    public final long mo148938a() {
        return this.f53170c - this.f53169b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final InputStream mo148939a(long j, long j2) throws IOException {
        long a = m37898a(this.f53169b);
        return this.f53168a.mo148939a(a, m37898a(j2 + a) - a);
    }

    public final void close() throws IOException {
    }
}
