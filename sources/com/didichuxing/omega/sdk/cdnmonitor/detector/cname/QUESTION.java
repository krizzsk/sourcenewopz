package com.didichuxing.omega.sdk.cdnmonitor.detector.cname;

public class QUESTION {
    private short qclass;
    private short qtype;

    public QUESTION(short s, short s2) {
        this.qtype = s;
        this.qclass = s2;
    }

    public byte[] toByteArray() {
        short s = this.qtype;
        short s2 = this.qclass;
        return new byte[]{(byte) (s >> 8), (byte) s, (byte) (s2 >> 8), (byte) s2};
    }
}
