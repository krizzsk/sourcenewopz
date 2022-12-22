package com.didichuxing.omega.sdk.cdnmonitor.detector.cname;

import java.nio.ByteBuffer;
import kotlin.UShort;

public class DNSInput {
    private ByteBuffer byteBuffer;

    public DNSInput(byte[] bArr) {
        this.byteBuffer = ByteBuffer.wrap(bArr);
    }

    public int readU16() {
        return this.byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    public void jump(int i) {
        this.byteBuffer.position(i);
        ByteBuffer byteBuffer2 = this.byteBuffer;
        byteBuffer2.limit(byteBuffer2.capacity());
    }

    public int readU8() {
        return this.byteBuffer.get() & 255;
    }

    public int current() {
        return this.byteBuffer.position();
    }
}
