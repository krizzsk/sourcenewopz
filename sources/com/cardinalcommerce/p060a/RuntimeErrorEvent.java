package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* renamed from: com.cardinalcommerce.a.RuntimeErrorEvent */
public class RuntimeErrorEvent implements KeySpec {
    public BigInteger Cardinal;
    public BigInteger configure;
    public BigInteger getInstance;
    public BigInteger init;

    public RuntimeErrorEvent(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.getInstance = bigInteger;
        this.Cardinal = bigInteger2;
        this.init = bigInteger3;
        this.configure = bigInteger4;
    }
}
