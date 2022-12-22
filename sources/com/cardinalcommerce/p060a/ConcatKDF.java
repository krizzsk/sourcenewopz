package com.cardinalcommerce.p060a;

import java.security.PrivateKey;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.ConcatKDF */
public interface ConcatKDF extends PrivateKey {
    PrivateKey configure();

    PublicKey getInstance();

    PrivateKey init();
}
