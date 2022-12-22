package org.bouncycastle.crypto.modes.kgcm;

public class BasicKGCMMultiplier_256 implements KGCMMultiplier {

    /* renamed from: H */
    private final long[] f6127H = new long[4];

    public void init(long[] jArr) {
        KGCMUtil_256.copy(jArr, this.f6127H);
    }

    public void multiplyH(long[] jArr) {
        KGCMUtil_256.multiply(jArr, this.f6127H, jArr);
    }
}
