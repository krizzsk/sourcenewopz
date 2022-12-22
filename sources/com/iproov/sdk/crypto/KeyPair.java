package com.iproov.sdk.crypto;

import android.content.Context;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;

public class KeyPair {
    private final C19915if keyStoreManager;

    /* renamed from: com.iproov.sdk.crypto.KeyPair$do */
    public enum C19912do {
        SOFTWARE,
        TEE,
        STRONG_BOX
    }

    public KeyPair(Context context) throws IProovException {
        try {
            this.keyStoreManager = C19915if.m39274do(context);
        } catch (C19914for e) {
            e.printStackTrace();
            throw new UnexpectedErrorException(context, (Exception) e);
        }
    }

    public C19912do getKeyStorageType() {
        if (!this.keyStoreManager.m47537break()) {
            return C19912do.SOFTWARE;
        }
        return this.keyStoreManager.m47540this() ? C19912do.STRONG_BOX : C19912do.TEE;
    }

    public PublicKey getPublicKey() {
        return this.keyStoreManager.m47538else();
    }

    public byte[] sign(byte[] bArr) throws IProovException {
        try {
            return this.keyStoreManager.mo162128do(bArr);
        } catch (C19914for e) {
            e.printStackTrace();
            throw new UnexpectedErrorException(this.keyStoreManager.m47541try(), (Exception) e);
        }
    }
}
