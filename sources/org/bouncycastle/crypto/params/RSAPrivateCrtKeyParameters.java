package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* renamed from: dP */
    private BigInteger f6190dP;

    /* renamed from: dQ */
    private BigInteger f6191dQ;

    /* renamed from: e */
    private BigInteger f6192e;

    /* renamed from: p */
    private BigInteger f6193p;

    /* renamed from: q */
    private BigInteger f6194q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f6192e = bigInteger2;
        this.f6193p = bigInteger4;
        this.f6194q = bigInteger5;
        this.f6190dP = bigInteger6;
        this.f6191dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.f6190dP;
    }

    public BigInteger getDQ() {
        return this.f6191dQ;
    }

    public BigInteger getP() {
        return this.f6193p;
    }

    public BigInteger getPublicExponent() {
        return this.f6192e;
    }

    public BigInteger getQ() {
        return this.f6194q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
