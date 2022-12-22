package com.jakewharton.disklrucache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.jakewharton.disklrucache.a */
/* compiled from: StrictLineReader */
class C19934a implements Closeable {

    /* renamed from: a */
    private static final byte f54487a = 13;

    /* renamed from: b */
    private static final byte f54488b = 10;

    /* renamed from: c */
    private final InputStream f54489c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Charset f54490d;

    /* renamed from: e */
    private byte[] f54491e;

    /* renamed from: f */
    private int f54492f;

    /* renamed from: g */
    private int f54493g;

    public C19934a(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C19934a(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C19935b.f54494a)) {
            this.f54489c = inputStream;
            this.f54490d = charset;
            this.f54491e = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f54489c) {
            if (this.f54491e != null) {
                this.f54491e = null;
                this.f54489c.close();
            }
        }
    }

    /* renamed from: a */
    public String mo162256a() throws IOException {
        int i;
        int i2;
        synchronized (this.f54489c) {
            if (this.f54491e != null) {
                if (this.f54492f >= this.f54493g) {
                    m39413c();
                }
                for (int i3 = this.f54492f; i3 != this.f54493g; i3++) {
                    if (this.f54491e[i3] == 10) {
                        if (i3 != this.f54492f) {
                            i2 = i3 - 1;
                            if (this.f54491e[i2] == 13) {
                                String str = new String(this.f54491e, this.f54492f, i2 - this.f54492f, this.f54490d.name());
                                this.f54492f = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f54491e, this.f54492f, i2 - this.f54492f, this.f54490d.name());
                        this.f54492f = i3 + 1;
                        return str2;
                    }
                }
                StrictLineReader$1 strictLineReader$1 = new StrictLineReader$1(this, (this.f54493g - this.f54492f) + 80);
                loop1:
                while (true) {
                    strictLineReader$1.write(this.f54491e, this.f54492f, this.f54493g - this.f54492f);
                    this.f54493g = -1;
                    m39413c();
                    i = this.f54492f;
                    while (true) {
                        if (i != this.f54493g) {
                            if (this.f54491e[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f54492f) {
                    strictLineReader$1.write(this.f54491e, this.f54492f, i - this.f54492f);
                }
                this.f54492f = i + 1;
                String byteArrayOutputStream = strictLineReader$1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public boolean mo162257b() {
        return this.f54493g == -1;
    }

    /* renamed from: c */
    private void m39413c() throws IOException {
        InputStream inputStream = this.f54489c;
        byte[] bArr = this.f54491e;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f54492f = 0;
            this.f54493g = read;
            return;
        }
        throw new EOFException();
    }
}
