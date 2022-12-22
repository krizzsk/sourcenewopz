package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class SRP6GroupParameters {

    /* renamed from: N */
    private BigInteger f6195N;

    /* renamed from: g */
    private BigInteger f6196g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f6195N = bigInteger;
        this.f6196g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f6196g;
    }

    public BigInteger getN() {
        return this.f6195N;
    }
}
