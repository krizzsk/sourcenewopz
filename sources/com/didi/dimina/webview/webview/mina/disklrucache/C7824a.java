package com.didi.dimina.webview.webview.mina.disklrucache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.didi.dimina.webview.webview.mina.disklrucache.a */
/* compiled from: StrictLineReader */
class C7824a implements Closeable {

    /* renamed from: a */
    private static final byte f18466a = 13;

    /* renamed from: b */
    private static final byte f18467b = 10;

    /* renamed from: c */
    private final InputStream f18468c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Charset f18469d;

    /* renamed from: e */
    private byte[] f18470e;

    /* renamed from: f */
    private int f18471f;

    /* renamed from: g */
    private int f18472g;

    public C7824a(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C7824a(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C7825b.f18473a)) {
            this.f18468c = inputStream;
            this.f18469d = charset;
            this.f18470e = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f18468c) {
            if (this.f18470e != null) {
                this.f18470e = null;
                this.f18468c.close();
            }
        }
    }

    /* renamed from: a */
    public String mo58122a() throws IOException {
        int i;
        int i2;
        synchronized (this.f18468c) {
            if (this.f18470e != null) {
                if (this.f18471f >= this.f18472g) {
                    m13709c();
                }
                for (int i3 = this.f18471f; i3 != this.f18472g; i3++) {
                    if (this.f18470e[i3] == 10) {
                        if (i3 != this.f18471f) {
                            i2 = i3 - 1;
                            if (this.f18470e[i2] == 13) {
                                String str = new String(this.f18470e, this.f18471f, i2 - this.f18471f, this.f18469d.name());
                                this.f18471f = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f18470e, this.f18471f, i2 - this.f18471f, this.f18469d.name());
                        this.f18471f = i3 + 1;
                        return str2;
                    }
                }
                StrictLineReader$1 strictLineReader$1 = new StrictLineReader$1(this, (this.f18472g - this.f18471f) + 80);
                loop1:
                while (true) {
                    strictLineReader$1.write(this.f18470e, this.f18471f, this.f18472g - this.f18471f);
                    this.f18472g = -1;
                    m13709c();
                    i = this.f18471f;
                    while (true) {
                        if (i != this.f18472g) {
                            if (this.f18470e[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f18471f) {
                    strictLineReader$1.write(this.f18470e, this.f18471f, i - this.f18471f);
                }
                this.f18471f = i + 1;
                String byteArrayOutputStream = strictLineReader$1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public boolean mo58123b() {
        return this.f18472g == -1;
    }

    /* renamed from: c */
    private void m13709c() throws IOException {
        InputStream inputStream = this.f18468c;
        byte[] bArr = this.f18470e;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f18471f = 0;
            this.f18472g = read;
            return;
        }
        throw new EOFException();
    }
}
