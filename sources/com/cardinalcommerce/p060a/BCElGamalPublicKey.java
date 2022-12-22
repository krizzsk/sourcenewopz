package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.BCElGamalPublicKey */
public final class BCElGamalPublicKey extends BCElGamalPrivateKey {
    public BigInteger Cardinal;

    public BCElGamalPublicKey(BigInteger bigInteger, CipherSpi cipherSpi) {
        super(true, cipherSpi);
        this.Cardinal = bigInteger;
    }

    public final int hashCode() {
        return this.Cardinal.hashCode() ^ super.hashCode();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof BCElGamalPublicKey) && ((BCElGamalPublicKey) obj).Cardinal.equals(this.Cardinal) && super.equals(obj);
    }
}
