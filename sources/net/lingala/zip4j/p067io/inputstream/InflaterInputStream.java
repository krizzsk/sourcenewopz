package net.lingala.zip4j.p067io.inputstream;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: net.lingala.zip4j.io.inputstream.InflaterInputStream */
public class InflaterInputStream extends C2387c {

    /* renamed from: a */
    private Inflater f4834a = new Inflater(true);

    /* renamed from: b */
    private byte[] f4835b;

    /* renamed from: c */
    private byte[] f4836c = new byte[1];

    /* renamed from: d */
    private int f4837d;

    public InflaterInputStream(C2386b bVar, int i) {
        super(bVar);
        this.f4835b = new byte[i];
    }

    public int read() throws IOException {
        if (read(this.f4836c) == -1) {
            return -1;
        }
        return this.f4836c[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            try {
                int inflate = this.f4834a.inflate(bArr, i, i2);
                if (inflate != 0) {
                    return inflate;
                }
                if (this.f4834a.finished()) {
                    return -1;
                }
                if (this.f4834a.needsDictionary()) {
                    return -1;
                }
                if (this.f4834a.needsInput()) {
                    m3118a();
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }

    public void endOfEntryReached(InputStream inputStream) throws IOException {
        Inflater inflater = this.f4834a;
        if (inflater != null) {
            inflater.end();
            this.f4834a = null;
        }
        super.endOfEntryReached(inputStream);
    }

    public void pushBackInputStreamIfNecessary(PushbackInputStream pushbackInputStream) throws IOException {
        int remaining = this.f4834a.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(getLastReadRawDataCache(), this.f4837d - remaining, remaining);
        }
    }

    public void close() throws IOException {
        Inflater inflater = this.f4834a;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    /* renamed from: a */
    private void m3118a() throws IOException {
        byte[] bArr = this.f4835b;
        int read = super.read(bArr, 0, bArr.length);
        this.f4837d = read;
        if (read != -1) {
            this.f4834a.setInput(this.f4835b, 0, read);
            return;
        }
        throw new EOFException("Unexpected end of input stream");
    }
}
