package com.iproov.sdk.crypto;

import p093switch.C3127throw;

public class PublicKey {
    private static final String PUBLIC_KEY_BEGIN = "-----BEGIN PUBLIC KEY-----\n";
    private static final String PUBLIC_KEY_END = "\n-----END PUBLIC KEY-----";
    private final java.security.PublicKey iProovPublicKey;

    PublicKey(java.security.PublicKey publicKey) {
        this.iProovPublicKey = publicKey;
    }

    public byte[] getDer() {
        return this.iProovPublicKey.getEncoded();
    }

    public java.security.PublicKey getKey() {
        return this.iProovPublicKey;
    }

    public String getPem() {
        return PUBLIC_KEY_BEGIN + C3127throw.m4050do(getDer()) + PUBLIC_KEY_END;
    }
}
