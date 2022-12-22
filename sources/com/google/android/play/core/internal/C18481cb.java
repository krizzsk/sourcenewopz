package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.cb */
public abstract class C18481cb implements Closeable {
    /* renamed from: a */
    public abstract long mo148938a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract InputStream mo148939a(long j, long j2) throws IOException;

    /* renamed from: b */
    public synchronized InputStream mo149133b() throws IOException {
        return mo148939a(0, mo148938a());
    }
}
