package com.jumio.ale.swig;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ALEInputStream extends FilterInputStream {

    /* renamed from: a */
    public ALERequest f54498a = null;

    /* renamed from: b */
    public InputStream f54499b;

    /* renamed from: c */
    public byte[] f54500c = new byte[512];

    /* renamed from: d */
    public boolean f54501d = false;

    /* renamed from: e */
    public byte[] f54502e;

    /* renamed from: f */
    public int f54503f = 0;

    /* renamed from: g */
    public int f54504g = 0;

    public ALEInputStream(InputStream inputStream, ALERequest aLERequest) {
        super(inputStream);
        this.f54499b = inputStream;
        this.f54498a = aLERequest;
        aLERequest.initResponse();
    }

    /* renamed from: a */
    public final int mo162267a() throws IOException {
        int i;
        if (this.f54501d) {
            return -1;
        }
        int read = this.f54499b.read(this.f54500c);
        if (read == -1) {
            this.f54501d = true;
            try {
                this.f54498a.finishResponse();
                return read;
            } catch (Exception e) {
                throw new IOException(e);
            }
        } else {
            try {
                byte[] bArr = this.f54500c;
                if (read != bArr.length) {
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    byte[] bArr3 = new byte[(read + 32)];
                    this.f54502e = bArr3;
                    i = this.f54498a.updateResponse(bArr2, bArr3);
                } else {
                    byte[] bArr4 = new byte[(bArr.length + 32)];
                    this.f54502e = bArr4;
                    i = this.f54498a.updateResponse(bArr, bArr4);
                }
                this.f54503f = 0;
                if (this.f54502e == null) {
                    this.f54504g = 0;
                } else {
                    this.f54504g = i;
                }
                return this.f54504g;
            } catch (Exception e2) {
                this.f54502e = null;
                throw new IOException(e2);
            }
        }
    }

    public int available() throws IOException {
        return this.f54504g - this.f54503f;
    }

    public void close() throws IOException {
        this.f54499b.close();
        try {
            if (!this.f54501d) {
                this.f54498a.finishResponse();
            }
            this.f54503f = 0;
            this.f54504g = 0;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public long skip(long j) throws IOException {
        int i = this.f54504g;
        int i2 = this.f54503f;
        long j2 = (long) (i - i2);
        if (j > j2) {
            j = j2;
        }
        if (j < 0) {
            return 0;
        }
        this.f54503f = (int) (((long) i2) + j);
        return j;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f54503f >= this.f54504g) {
            int i3 = 0;
            while (i3 == 0) {
                i3 = mo162267a();
            }
            if (i3 == -1) {
                return -1;
            }
        }
        if (i2 <= 0) {
            return 0;
        }
        int i4 = this.f54504g;
        int i5 = this.f54503f;
        int i6 = i4 - i5;
        if (i2 >= i6) {
            i2 = i6;
        }
        if (bArr != null) {
            System.arraycopy(this.f54502e, i5, bArr, i, i2);
        }
        this.f54503f += i2;
        return i2;
    }
}
