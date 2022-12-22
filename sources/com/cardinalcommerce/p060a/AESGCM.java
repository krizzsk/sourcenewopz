package com.cardinalcommerce.p060a;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.AESGCM */
public interface AESGCM extends Key {
    PublicKey cca_continue();

    PrivateKey getInstance();
}
