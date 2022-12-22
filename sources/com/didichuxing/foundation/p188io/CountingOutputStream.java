package com.didichuxing.foundation.p188io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.didichuxing.foundation.io.CountingOutputStream */
public class CountingOutputStream extends FilterOutputStream {

    /* renamed from: a */
    private long f47560a = 0;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void write(int i) throws IOException {
        super.write(i);
        count(1);
    }

    public void write(byte[] bArr) throws IOException {
        super.write(bArr);
        count((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
        count((long) i2);
    }

    /* access modifiers changed from: protected */
    public void count(long j) {
        if (j != -1) {
            this.f47560a += j;
        }
    }

    public long getBytesWritten() {
        return this.f47560a;
    }
}
