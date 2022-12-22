package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;

public class GOST3411_2012_512Digest extends GOST3411_2012Digest {

    /* renamed from: IV */
    private static final byte[] f5794IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public GOST3411_2012_512Digest() {
        super(f5794IV);
    }

    public GOST3411_2012_512Digest(GOST3411_2012_512Digest gOST3411_2012_512Digest) {
        super(f5794IV);
        reset(gOST3411_2012_512Digest);
    }

    public Memoable copy() {
        return new GOST3411_2012_512Digest(this);
    }

    public String getAlgorithmName() {
        return "GOST3411-2012-512";
    }

    public int getDigestSize() {
        return 64;
    }
}
