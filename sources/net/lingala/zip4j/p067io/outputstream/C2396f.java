package net.lingala.zip4j.p067io.outputstream;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: net.lingala.zip4j.io.outputstream.f */
/* compiled from: ZipEntryOutputStream */
class C2396f extends OutputStream {

    /* renamed from: a */
    private long f4905a = 0;

    /* renamed from: b */
    private OutputStream f4906b;

    /* renamed from: c */
    private boolean f4907c;

    public void close() throws IOException {
    }

    public C2396f(OutputStream outputStream) {
        this.f4906b = outputStream;
        this.f4907c = false;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f4907c) {
            this.f4906b.write(bArr, i, i2);
            this.f4905a += (long) i2;
            return;
        }
        throw new IllegalStateException("ZipEntryOutputStream is closed");
    }

    /* renamed from: a */
    public void mo24198a() throws IOException {
        this.f4907c = true;
    }

    /* renamed from: b */
    public long mo24199b() {
        return this.f4905a;
    }
}
