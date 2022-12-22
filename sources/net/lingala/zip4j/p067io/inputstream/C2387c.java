package net.lingala.zip4j.p067io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* renamed from: net.lingala.zip4j.io.inputstream.c */
/* compiled from: DecompressedInputStream */
abstract class C2387c extends InputStream {

    /* renamed from: a */
    private C2386b f4871a;
    protected byte[] oneByteBuffer = new byte[1];

    public void pushBackInputStreamIfNecessary(PushbackInputStream pushbackInputStream) throws IOException {
    }

    public C2387c(C2386b bVar) {
        this.f4871a = bVar;
    }

    public int read() throws IOException {
        if (read(this.oneByteBuffer) == -1) {
            return -1;
        }
        return this.oneByteBuffer[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f4871a.read(bArr, i, i2);
    }

    public void close() throws IOException {
        this.f4871a.close();
    }

    public void endOfEntryReached(InputStream inputStream) throws IOException {
        this.f4871a.mo24135a(inputStream);
    }

    /* access modifiers changed from: protected */
    public byte[] getLastReadRawDataCache() {
        return this.f4871a.mo24141a();
    }
}
