package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zztv extends PushbackInputStream {
    private final /* synthetic */ zztq zzbwq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zztv(zztq zztq, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbwq = zztq;
    }

    public final synchronized void close() throws IOException {
        this.zzbwq.zzbwj.disconnect();
        super.close();
    }
}
