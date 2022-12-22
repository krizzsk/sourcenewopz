package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

public class QUESTION {

    /* renamed from: a */
    private short f47775a;

    /* renamed from: b */
    private short f47776b;

    public QUESTION(short s, short s2) {
        this.f47775a = s;
        this.f47776b = s2;
    }

    public byte[] toByteArray() {
        short s = this.f47775a;
        short s2 = this.f47776b;
        return new byte[]{(byte) (s >> 8), (byte) s, (byte) (s2 >> 8), (byte) s2};
    }
}
