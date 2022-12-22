package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

import java.nio.ByteBuffer;
import kotlin.UShort;

public class DNSInput {

    /* renamed from: a */
    private ByteBuffer f47771a;

    public DNSInput(byte[] bArr) {
        this.f47771a = ByteBuffer.wrap(bArr);
    }

    public int readU16() {
        return this.f47771a.getShort() & UShort.MAX_VALUE;
    }

    public void jump(int i) {
        this.f47771a.position(i);
        ByteBuffer byteBuffer = this.f47771a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public int readU8() {
        return this.f47771a.get() & 255;
    }

    public int current() {
        return this.f47771a.position();
    }
}
