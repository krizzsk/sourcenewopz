package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* renamed from: com.cardinalcommerce.a.JWTClaimsSet */
public class JWTClaimsSet implements KeySpec {
    public BigInteger Cardinal;
    public BigInteger cca_continue;
    public BigInteger configure;
    public BigInteger init;

    public JWTClaimsSet(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.init = bigInteger;
        this.cca_continue = bigInteger2;
        this.configure = bigInteger3;
        this.Cardinal = bigInteger4;
    }
}
