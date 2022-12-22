package com.koushikdutta.async.http.cache;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.koushikdutta.async.util.Charsets;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.koushikdutta.async.http.cache.e */
/* compiled from: StrictLineReader */
class C20220e implements Closeable {

    /* renamed from: a */
    private static final byte f55397a = 13;

    /* renamed from: b */
    private static final byte f55398b = 10;

    /* renamed from: c */
    private final InputStream f55399c;

    /* renamed from: d */
    private byte[] f55400d;

    /* renamed from: e */
    private int f55401e;

    /* renamed from: f */
    private int f55402f;

    public C20220e(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public C20220e(InputStream inputStream, int i) {
        this(inputStream, i, Charsets.US_ASCII);
    }

    public C20220e(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C20220e(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        } else if (charset == null) {
            throw new NullPointerException("charset == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(Charsets.US_ASCII) || charset.equals(Charsets.UTF_8)) {
            this.f55399c = inputStream;
            this.f55400d = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f55399c) {
            if (this.f55400d != null) {
                this.f55400d = null;
                this.f55399c.close();
            }
        }
    }

    /* renamed from: a */
    public String mo164358a() throws IOException {
        int i;
        int i2;
        synchronized (this.f55399c) {
            if (this.f55400d != null) {
                if (this.f55401e >= this.f55402f) {
                    m39984d();
                }
                for (int i3 = this.f55401e; i3 != this.f55402f; i3++) {
                    if (this.f55400d[i3] == 10) {
                        if (i3 != this.f55401e) {
                            i2 = i3 - 1;
                            if (this.f55400d[i2] == 13) {
                                String str = new String(this.f55400d, this.f55401e, i2 - this.f55401e);
                                this.f55401e = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f55400d, this.f55401e, i2 - this.f55401e);
                        this.f55401e = i3 + 1;
                        return str2;
                    }
                }
                StrictLineReader$1 strictLineReader$1 = new StrictLineReader$1(this, (this.f55402f - this.f55401e) + 80);
                loop1:
                while (true) {
                    strictLineReader$1.write(this.f55400d, this.f55401e, this.f55402f - this.f55401e);
                    this.f55402f = -1;
                    m39984d();
                    i = this.f55401e;
                    while (true) {
                        if (i != this.f55402f) {
                            if (this.f55400d[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f55401e) {
                    strictLineReader$1.write(this.f55400d, this.f55401e, i - this.f55401e);
                }
                this.f55401e = i + 1;
                String byteArrayOutputStream = strictLineReader$1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public int mo164359b() throws IOException {
        String a = mo164358a();
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException unused) {
            throw new IOException("expected an int but was \"" + a + Const.jsQuote);
        }
    }

    /* renamed from: c */
    public boolean mo164360c() {
        return this.f55402f == -1;
    }

    /* renamed from: d */
    private void m39984d() throws IOException {
        InputStream inputStream = this.f55399c;
        byte[] bArr = this.f55400d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f55401e = 0;
            this.f55402f = read;
            return;
        }
        throw new EOFException();
    }
}
