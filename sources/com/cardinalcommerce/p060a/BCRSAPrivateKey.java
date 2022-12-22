package com.cardinalcommerce.p060a;

import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.BCRSAPrivateKey */
public final class BCRSAPrivateKey extends GOST3410Util {
    public BCRSAPublicKey configure;

    public BCRSAPrivateKey(BCRSAPublicKey bCRSAPublicKey, SecureRandom secureRandom) {
        super(secureRandom, bCRSAPublicKey.cca_continue.bitLength());
        this.configure = bCRSAPublicKey;
    }
}
