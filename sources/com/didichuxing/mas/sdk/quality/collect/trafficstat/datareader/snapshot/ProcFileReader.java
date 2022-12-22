package com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.nio.charset.Charset;

public class ProcFileReader implements Closeable {

    /* renamed from: a */
    private final InputStream f48240a;

    /* renamed from: b */
    private final byte[] f48241b;

    /* renamed from: c */
    private int f48242c;

    /* renamed from: d */
    private boolean f48243d;

    public ProcFileReader(InputStream inputStream) throws IOException {
        this(inputStream, 4096);
    }

    public ProcFileReader(InputStream inputStream, int i) throws IOException {
        this.f48240a = inputStream;
        this.f48241b = new byte[i];
        m34382a();
    }

    /* renamed from: a */
    private int m34382a() throws IOException {
        byte[] bArr = this.f48241b;
        int length = bArr.length;
        int i = this.f48242c;
        int i2 = length - i;
        if (i2 != 0) {
            int read = this.f48240a.read(bArr, i, i2);
            if (read != -1) {
                this.f48242c += read;
            }
            return read;
        }
        throw new IOException("attempting to fill already-full buffer");
    }

    /* renamed from: a */
    private void m34383a(int i) throws IOException {
        byte[] bArr = this.f48241b;
        System.arraycopy(bArr, i, bArr, 0, this.f48242c - i);
        int i2 = this.f48242c - i;
        this.f48242c = i2;
        if (i2 == 0) {
            m34382a();
        }
    }

    /* renamed from: b */
    private int m34384b() throws IOException {
        if (this.f48243d) {
            return -1;
        }
        int i = 0;
        while (true) {
            if (i < this.f48242c) {
                byte b = this.f48241b[i];
                if (b == 10) {
                    this.f48243d = true;
                    return i;
                } else if (b == 32) {
                    return i;
                } else {
                    i++;
                }
            } else if (m34382a() <= 0) {
                throw new ProtocolException("End of stream while looking for token boundary");
            }
        }
    }

    public boolean hasMoreData() {
        return this.f48242c > 0;
    }

    public void finishLine() throws IOException {
        int i = 0;
        if (this.f48243d) {
            this.f48243d = false;
            return;
        }
        while (true) {
            if (i < this.f48242c) {
                if (this.f48241b[i] == 10) {
                    m34383a(i + 1);
                    return;
                }
                i++;
            } else if (m34382a() <= 0) {
                throw new ProtocolException("End of stream while looking for line boundary");
            }
        }
    }

    public String nextString() throws IOException {
        int b = m34384b();
        if (b != -1) {
            return m34385b(b);
        }
        throw new ProtocolException("Missing required string");
    }

    public long nextLong() throws IOException {
        int b = m34384b();
        if (b != -1) {
            return m34386c(b);
        }
        throw new ProtocolException("Missing required long");
    }

    public long nextOptionalLong(long j) throws IOException {
        int b = m34384b();
        if (b == -1) {
            return j;
        }
        return m34386c(b);
    }

    /* renamed from: b */
    private String m34385b(int i) throws IOException {
        String str = new String(this.f48241b, 0, i, Charset.forName("US-ASCII"));
        m34383a(i + 1);
        return str;
    }

    /* renamed from: c */
    private long m34386c(int i) throws IOException {
        int i2 = 0;
        if (this.f48241b[0] == 45) {
            i2 = 1;
        }
        long j = 0;
        int i3 = i2;
        while (i3 < i) {
            int i4 = this.f48241b[i3] - 48;
            if (i4 < 0 || i4 > 9) {
                throw m34387d(i);
            }
            long j2 = (10 * j) - ((long) i4);
            if (j2 <= j) {
                i3++;
                j = j2;
            } else {
                throw m34387d(i);
            }
        }
        m34383a(i + 1);
        return i2 != 0 ? j : -j;
    }

    /* renamed from: d */
    private NumberFormatException m34387d(int i) {
        return new NumberFormatException("invalid long: " + new String(this.f48241b, 0, i, Charset.forName("US-ASCII")));
    }

    public int nextInt() throws IOException {
        long nextLong = nextLong();
        if (nextLong <= 2147483647L && nextLong >= -2147483648L) {
            return (int) nextLong;
        }
        throw new NumberFormatException("parsed value larger than integer");
    }

    public void close() throws IOException {
        this.f48240a.close();
    }
}
