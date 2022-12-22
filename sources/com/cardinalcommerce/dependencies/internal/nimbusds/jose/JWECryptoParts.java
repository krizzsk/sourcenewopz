package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;

public final class JWECryptoParts {

    /* renamed from: a */
    final JWEHeader f3230a;

    /* renamed from: b */
    final Base64URL f3231b;

    /* renamed from: c */
    final Base64URL f3232c;

    /* renamed from: d */
    final Base64URL f3233d;

    /* renamed from: e */
    final Base64URL f3234e;

    public JWECryptoParts(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) {
        this.f3230a = jWEHeader;
        this.f3231b = base64URL;
        this.f3232c = base64URL2;
        if (base64URL3 != null) {
            this.f3233d = base64URL3;
            this.f3234e = base64URL4;
            return;
        }
        throw new IllegalArgumentException("The cipher text must not be null");
    }
}
