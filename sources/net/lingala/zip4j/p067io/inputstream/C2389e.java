package net.lingala.zip4j.p067io.inputstream;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: net.lingala.zip4j.io.inputstream.e */
/* compiled from: ZipEntryInputStream */
class C2389e extends InputStream {

    /* renamed from: a */
    private static final int f4872a = 15;

    /* renamed from: b */
    private InputStream f4873b;

    /* renamed from: c */
    private long f4874c = 0;

    /* renamed from: d */
    private byte[] f4875d = new byte[1];

    /* renamed from: e */
    private long f4876e;

    public C2389e(InputStream inputStream, long j) {
        this.f4873b = inputStream;
        this.f4876e = j;
    }

    public int read() throws IOException {
        if (read(this.f4875d) == -1) {
            return -1;
        }
        return this.f4875d[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f4876e;
        if (j != -1) {
            long j2 = this.f4874c;
            if (j2 >= j) {
                return -1;
            }
            if (((long) i2) > j - j2) {
                i2 = (int) (j - j2);
            }
        }
        int read = this.f4873b.read(bArr, i, i2);
        if (read > 0) {
            this.f4874c += (long) read;
        }
        return read;
    }

    /* renamed from: a */
    public int mo24147a(byte[] bArr) throws IOException {
        int read = this.f4873b.read(bArr);
        if (read == bArr.length || (read = m3154a(bArr, read)) == bArr.length) {
            return read;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    /* renamed from: a */
    private int m3154a(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int i2 = 0;
        int i3 = 0;
        while (i < bArr.length && i2 != -1 && i3 < 15) {
            i2 += this.f4873b.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
            i3++;
        }
        return i;
    }

    public void close() throws IOException {
        this.f4873b.close();
    }

    /* renamed from: a */
    public long mo24148a() {
        return this.f4874c;
    }
}
