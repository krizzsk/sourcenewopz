package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private long[] f6118H;

    public void init(byte[] bArr) {
        this.f6118H = GCMUtil.asLongs(bArr);
    }

    public void multiplyH(byte[] bArr) {
        long[] asLongs = GCMUtil.asLongs(bArr);
        GCMUtil.multiply(asLongs, this.f6118H);
        GCMUtil.asBytes(asLongs, bArr);
    }
}
