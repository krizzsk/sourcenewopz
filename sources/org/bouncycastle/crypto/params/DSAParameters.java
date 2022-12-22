package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f6155g;

    /* renamed from: p */
    private BigInteger f6156p;

    /* renamed from: q */
    private BigInteger f6157q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f6155g = bigInteger3;
        this.f6156p = bigInteger;
        this.f6157q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f6155g = bigInteger3;
        this.f6156p = bigInteger;
        this.f6157q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.getP().equals(this.f6156p) && dSAParameters.getQ().equals(this.f6157q) && dSAParameters.getG().equals(this.f6155g);
    }

    public BigInteger getG() {
        return this.f6155g;
    }

    public BigInteger getP() {
        return this.f6156p;
    }

    public BigInteger getQ() {
        return this.f6157q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
