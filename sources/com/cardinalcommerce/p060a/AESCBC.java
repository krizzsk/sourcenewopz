package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import javax.crypto.interfaces.DHPrivateKey;

/* renamed from: com.cardinalcommerce.a.AESCBC */
public interface AESCBC extends AAD, DHPrivateKey {
    BigInteger getX();
}
