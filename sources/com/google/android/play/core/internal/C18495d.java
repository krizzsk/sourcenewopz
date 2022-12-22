package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.d */
final class C18495d implements C18479c {

    /* renamed from: a */
    private final FileChannel f53180a;

    /* renamed from: b */
    private final long f53181b;

    /* renamed from: c */
    private final long f53182c;

    public C18495d(FileChannel fileChannel, long j, long j2) {
        this.f53180a = fileChannel;
        this.f53181b = j;
        this.f53182c = j2;
    }

    /* renamed from: a */
    public final long mo149104a() {
        return this.f53182c;
    }

    /* renamed from: a */
    public final void mo149105a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f53180a.map(FileChannel.MapMode.READ_ONLY, this.f53181b + j, (long) i);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
