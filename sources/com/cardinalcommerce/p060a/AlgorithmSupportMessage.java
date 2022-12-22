package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.AlgorithmSupportMessage */
public interface AlgorithmSupportMessage extends RSAEncrypter, PrivateKey {
    BigInteger getInstance();
}
