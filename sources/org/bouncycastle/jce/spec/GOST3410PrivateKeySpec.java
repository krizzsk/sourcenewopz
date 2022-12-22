package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f6281a;

    /* renamed from: p */
    private BigInteger f6282p;

    /* renamed from: q */
    private BigInteger f6283q;

    /* renamed from: x */
    private BigInteger f6284x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f6284x = bigInteger;
        this.f6282p = bigInteger2;
        this.f6283q = bigInteger3;
        this.f6281a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f6281a;
    }

    public BigInteger getP() {
        return this.f6282p;
    }

    public BigInteger getQ() {
        return this.f6283q;
    }

    public BigInteger getX() {
        return this.f6284x;
    }
}
