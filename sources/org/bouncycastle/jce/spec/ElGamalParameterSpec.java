package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g */
    private BigInteger f6277g;

    /* renamed from: p */
    private BigInteger f6278p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f6278p = bigInteger;
        this.f6277g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f6277g;
    }

    public BigInteger getP() {
        return this.f6278p;
    }
}
