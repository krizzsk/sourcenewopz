package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f6165g;

    /* renamed from: l */
    private int f6166l;

    /* renamed from: p */
    private BigInteger f6167p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f6165g = bigInteger2;
        this.f6167p = bigInteger;
        this.f6166l = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.f6167p) && elGamalParameters.getG().equals(this.f6165g) && elGamalParameters.getL() == this.f6166l;
    }

    public BigInteger getG() {
        return this.f6165g;
    }

    public int getL() {
        return this.f6166l;
    }

    public BigInteger getP() {
        return this.f6167p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f6166l;
    }
}
