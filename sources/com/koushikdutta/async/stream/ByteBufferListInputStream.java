package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import java.io.IOException;
import java.io.InputStream;

public class ByteBufferListInputStream extends InputStream {

    /* renamed from: a */
    ByteBufferList f55438a;

    public ByteBufferListInputStream(ByteBufferList byteBufferList) {
        this.f55438a = byteBufferList;
    }

    public int read() throws IOException {
        if (this.f55438a.remaining() <= 0) {
            return -1;
        }
        return this.f55438a.get() & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f55438a.remaining() <= 0) {
            return -1;
        }
        int min = Math.min(i2, this.f55438a.remaining());
        this.f55438a.get(bArr, i, min);
        return min;
    }
}
