package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.AuthenticatedCipherText */
public interface AuthenticatedCipherText extends RSAEncrypter, PublicKey {
    BigInteger Cardinal();
}
