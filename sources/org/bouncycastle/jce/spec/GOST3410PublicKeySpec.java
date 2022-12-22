package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f6288a;

    /* renamed from: p */
    private BigInteger f6289p;

    /* renamed from: q */
    private BigInteger f6290q;

    /* renamed from: y */
    private BigInteger f6291y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f6291y = bigInteger;
        this.f6289p = bigInteger2;
        this.f6290q = bigInteger3;
        this.f6288a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f6288a;
    }

    public BigInteger getP() {
        return this.f6289p;
    }

    public BigInteger getQ() {
        return this.f6290q;
    }

    public BigInteger getY() {
        return this.f6291y;
    }
}
