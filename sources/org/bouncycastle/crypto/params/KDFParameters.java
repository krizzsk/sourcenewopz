package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

public class KDFParameters implements DerivationParameters {

    /* renamed from: iv */
    byte[] f6185iv;
    byte[] shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.shared = bArr;
        this.f6185iv = bArr2;
    }

    public byte[] getIV() {
        return this.f6185iv;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }
}
