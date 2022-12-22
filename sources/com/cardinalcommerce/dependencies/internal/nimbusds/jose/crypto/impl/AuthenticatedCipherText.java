package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

public final class AuthenticatedCipherText {

    /* renamed from: a */
    private final byte[] f3243a;

    /* renamed from: b */
    private final byte[] f3244b;

    public AuthenticatedCipherText(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            this.f3243a = bArr;
            if (bArr2 != null) {
                this.f3244b = bArr2;
                return;
            }
            throw new IllegalArgumentException("The authentication tag must not be null");
        }
        throw new IllegalArgumentException("The cipher text must not be null");
    }

    public final byte[] Cardinal() {
        return this.f3243a;
    }

    public final byte[] getInstance() {
        return this.f3244b;
    }
}
