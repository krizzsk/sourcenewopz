package com.didichuxing.omega.sdk.cdnmonitor.detector.cname;

import java.util.Random;

class Header {
    private static Random random = new Random();
    private short[] counts;
    private short flags;

    /* renamed from: id */
    private short f48474id;

    static short setFlag(short s, int i, boolean z) {
        return (short) (z ? s | (1 << (15 - i)) : s & (~(1 << (15 - i))));
    }

    private void init() {
        this.counts = new short[4];
        this.flags = 0;
        this.f48474id = (short) random.nextInt(32767);
    }

    public Header() {
        init();
    }

    public void setFlag(int i) {
        this.flags = setFlag(this.flags, i, true);
    }

    public void setCount(short s, short s2) {
        this.counts[s] = s2;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[12];
        short s = this.f48474id;
        bArr[0] = (byte) (s >> 8);
        bArr[1] = (byte) s;
        short s2 = this.flags;
        bArr[2] = (byte) (s2 >> 8);
        bArr[3] = (byte) s2;
        int i = 4;
        for (int i2 = 0; i2 < 4; i2++) {
            short[] sArr = this.counts;
            bArr[i] = (byte) (sArr[i2] >> 8);
            bArr[i + 1] = (byte) sArr[i2];
            i += 2;
        }
        return bArr;
    }
}
