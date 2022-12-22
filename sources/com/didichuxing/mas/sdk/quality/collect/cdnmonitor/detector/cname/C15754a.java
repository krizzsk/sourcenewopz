package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

import java.util.Random;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname.a */
/* compiled from: Header */
class C15754a {

    /* renamed from: d */
    private static Random f47777d = new Random();

    /* renamed from: a */
    private short f47778a;

    /* renamed from: b */
    private short f47779b;

    /* renamed from: c */
    private short[] f47780c;

    /* renamed from: a */
    static short m34204a(short s, int i, boolean z) {
        return (short) (z ? s | (1 << (15 - i)) : s & (~(1 << (15 - i))));
    }

    /* renamed from: b */
    private void m34205b() {
        this.f47780c = new short[4];
        this.f47779b = 0;
        this.f47778a = (short) f47777d.nextInt(32767);
    }

    public C15754a() {
        m34205b();
    }

    /* renamed from: a */
    public void mo117839a(int i) {
        this.f47779b = m34204a(this.f47779b, i, true);
    }

    /* renamed from: a */
    public void mo117840a(short s, short s2) {
        this.f47780c[s] = s2;
    }

    /* renamed from: a */
    public byte[] mo117841a() {
        byte[] bArr = new byte[12];
        short s = this.f47778a;
        bArr[0] = (byte) (s >> 8);
        bArr[1] = (byte) s;
        short s2 = this.f47779b;
        bArr[2] = (byte) (s2 >> 8);
        bArr[3] = (byte) s2;
        int i = 4;
        for (int i2 = 0; i2 < 4; i2++) {
            short[] sArr = this.f47780c;
            bArr[i] = (byte) (sArr[i2] >> 8);
            bArr[i + 1] = (byte) sArr[i2];
            i += 2;
        }
        return bArr;
    }
}
