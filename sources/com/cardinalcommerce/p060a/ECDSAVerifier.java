package com.cardinalcommerce.p060a;

import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.ECDSAVerifier */
public interface ECDSAVerifier extends JWSVerifier, PublicKey {
    ChallengeParameters configure();
}
