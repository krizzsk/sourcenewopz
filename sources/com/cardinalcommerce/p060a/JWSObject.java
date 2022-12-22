package com.cardinalcommerce.p060a;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.cardinalcommerce.a.JWSObject */
public final class JWSObject extends DirectEncrypter {

    /* renamed from: a */
    private static volatile Provider f2452a;

    public JWSObject() {
        super(m1816a());
    }

    /* renamed from: a */
    private static synchronized Provider m1816a() {
        synchronized (JWSObject.class) {
            if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) != null) {
                Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
                return provider;
            } else if (f2452a != null) {
                Provider provider2 = f2452a;
                return provider2;
            } else {
                JWK jwk = new JWK();
                f2452a = jwk;
                return jwk;
            }
        }
    }
}
