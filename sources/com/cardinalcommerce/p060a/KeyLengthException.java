package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.PrivateKey;

/* renamed from: com.cardinalcommerce.a.KeyLengthException */
public interface KeyLengthException extends JWSVerifier, PrivateKey {
    BigInteger getInstance();
}
