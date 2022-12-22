package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA384Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 48;

    public SHA384Digest() {
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
    }

    public SHA384Digest(byte[] bArr) {
        restoreState(bArr);
    }

    public Memoable copy() {
        return new SHA384Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.longToBigEndian(this.f5799H1, bArr, i);
        Pack.longToBigEndian(this.f5800H2, bArr, i + 8);
        Pack.longToBigEndian(this.f5801H3, bArr, i + 16);
        Pack.longToBigEndian(this.f5802H4, bArr, i + 24);
        Pack.longToBigEndian(this.f5803H5, bArr, i + 32);
        Pack.longToBigEndian(this.f5804H6, bArr, i + 40);
        reset();
        return 48;
    }

    public String getAlgorithmName() {
        return "SHA-384";
    }

    public int getDigestSize() {
        return 48;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[getEncodedStateSize()];
        super.populateState(bArr);
        return bArr;
    }

    public void reset() {
        super.reset();
        this.f5799H1 = -3766243637369397544L;
        this.f5800H2 = 7105036623409894663L;
        this.f5801H3 = -7973340178411365097L;
        this.f5802H4 = 1526699215303891257L;
        this.f5803H5 = 7436329637833083697L;
        this.f5804H6 = -8163818279084223215L;
        this.f5805H7 = -2662702644619276377L;
        this.f5806H8 = 5167115440072839076L;
    }

    public void reset(Memoable memoable) {
        super.copyIn((SHA384Digest) memoable);
    }
}
