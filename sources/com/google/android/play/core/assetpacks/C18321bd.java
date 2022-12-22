package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.assetpacks.bd */
final class C18321bd extends InputStream {

    /* renamed from: a */
    private final InputStream f52802a;

    /* renamed from: b */
    private long f52803b;

    C18321bd(InputStream inputStream, long j) {
        this.f52802a = inputStream;
        this.f52803b = j;
    }

    public final void close() throws IOException {
        super.close();
        this.f52802a.close();
        this.f52803b = 0;
    }

    public final int read() throws IOException {
        long j = this.f52803b;
        if (j <= 0) {
            return -1;
        }
        this.f52803b = j - 1;
        return this.f52802a.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f52803b;
        if (j <= 0) {
            return -1;
        }
        int read = this.f52802a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f52803b -= (long) read;
        }
        return read;
    }
}
