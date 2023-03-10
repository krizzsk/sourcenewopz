package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {

    /* renamed from: x */
    private BigInteger f6173x;

    public GOST3410PrivateKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(true, gOST3410Parameters);
        this.f6173x = bigInteger;
    }

    public BigInteger getX() {
        return this.f6173x;
    }
}
