package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.b */
final class C18452b implements C18479c {

    /* renamed from: a */
    private final ByteBuffer f53162a;

    public C18452b(ByteBuffer byteBuffer) {
        this.f53162a = byteBuffer.slice();
    }

    /* renamed from: a */
    public final long mo149104a() {
        return (long) this.f53162a.capacity();
    }

    /* renamed from: a */
    public final void mo149105a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.f53162a) {
            int i2 = (int) j;
            this.f53162a.position(i2);
            this.f53162a.limit(i2 + i);
            slice = this.f53162a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
