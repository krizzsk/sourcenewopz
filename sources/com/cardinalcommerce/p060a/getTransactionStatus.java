package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* renamed from: com.cardinalcommerce.a.getTransactionStatus */
public class getTransactionStatus implements AlgorithmParameterSpec {
    public BigInteger Cardinal;
    public BigInteger configure;

    public getTransactionStatus(BigInteger bigInteger, BigInteger bigInteger2) {
        this.configure = bigInteger;
        this.Cardinal = bigInteger2;
    }
}
