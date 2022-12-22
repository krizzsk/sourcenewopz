package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;

/* renamed from: com.cardinalcommerce.a.RSASSAVerifier */
public interface RSASSAVerifier extends AAD, DHPublicKey {
    BigInteger getY();
}
