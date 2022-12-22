package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a */
    private BigInteger f6285a;

    /* renamed from: p */
    private BigInteger f6286p;

    /* renamed from: q */
    private BigInteger f6287q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f6286p = bigInteger;
        this.f6287q = bigInteger2;
        this.f6285a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        return this.f6285a.equals(gOST3410PublicKeyParameterSetSpec.f6285a) && this.f6286p.equals(gOST3410PublicKeyParameterSetSpec.f6286p) && this.f6287q.equals(gOST3410PublicKeyParameterSetSpec.f6287q);
    }

    public BigInteger getA() {
        return this.f6285a;
    }

    public BigInteger getP() {
        return this.f6286p;
    }

    public BigInteger getQ() {
        return this.f6287q;
    }

    public int hashCode() {
        return (this.f6285a.hashCode() ^ this.f6286p.hashCode()) ^ this.f6287q.hashCode();
    }
}
