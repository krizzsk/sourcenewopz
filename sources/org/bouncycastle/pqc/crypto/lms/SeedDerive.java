package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

class SeedDerive {

    /* renamed from: I */
    private final byte[] f6480I;
    private final Digest digest;

    /* renamed from: j */
    private int f6481j;
    private final byte[] masterSeed;

    /* renamed from: q */
    private int f6482q;

    public SeedDerive(byte[] bArr, byte[] bArr2, Digest digest2) {
        this.f6480I = bArr;
        this.masterSeed = bArr2;
        this.digest = digest2;
    }

    public void deriveSeed(byte[] bArr, boolean z) {
        deriveSeed(bArr, z, 0);
    }

    public void deriveSeed(byte[] bArr, boolean z, int i) {
        deriveSeed(bArr, i);
        if (z) {
            this.f6481j++;
        }
    }

    public byte[] deriveSeed(byte[] bArr, int i) {
        if (bArr.length >= this.digest.getDigestSize()) {
            Digest digest2 = this.digest;
            byte[] bArr2 = this.f6480I;
            digest2.update(bArr2, 0, bArr2.length);
            this.digest.update((byte) (this.f6482q >>> 24));
            this.digest.update((byte) (this.f6482q >>> 16));
            this.digest.update((byte) (this.f6482q >>> 8));
            this.digest.update((byte) this.f6482q);
            this.digest.update((byte) (this.f6481j >>> 8));
            this.digest.update((byte) this.f6481j);
            this.digest.update((byte) -1);
            Digest digest3 = this.digest;
            byte[] bArr3 = this.masterSeed;
            digest3.update(bArr3, 0, bArr3.length);
            this.digest.doFinal(bArr, i);
            return bArr;
        }
        throw new IllegalArgumentException("target length is less than digest size.");
    }

    public byte[] getI() {
        return this.f6480I;
    }

    public int getJ() {
        return this.f6481j;
    }

    public byte[] getMasterSeed() {
        return this.masterSeed;
    }

    public int getQ() {
        return this.f6482q;
    }

    public void setJ(int i) {
        this.f6481j = i;
    }

    public void setQ(int i) {
        this.f6482q = i;
    }
}
