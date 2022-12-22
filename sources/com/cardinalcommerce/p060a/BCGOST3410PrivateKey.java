package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.BCGOST3410PrivateKey */
public final class BCGOST3410PrivateKey extends ElGamalUtil {
    private static final BigInteger configure = BigInteger.valueOf(2);
    private static final BigInteger init = BigInteger.valueOf(1);
    public BigInteger cca_continue;

    public BCGOST3410PrivateKey(BigInteger bigInteger, BCGOST3410PublicKey bCGOST3410PublicKey) {
        super(false, bCGOST3410PublicKey);
        if (bCGOST3410PublicKey == null || (configure.compareTo(bigInteger) <= 0 && bCGOST3410PublicKey.init.subtract(configure).compareTo(bigInteger) >= 0 && init.equals(bigInteger.modPow(bCGOST3410PublicKey.getInstance, bCGOST3410PublicKey.init)))) {
            this.cca_continue = bigInteger;
            return;
        }
        throw new IllegalArgumentException("y value does not appear to be in correct group");
    }
}
