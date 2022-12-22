package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithID implements CipherParameters {

    /* renamed from: id */
    private byte[] f6188id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f6188id = bArr;
    }

    public byte[] getID() {
        return this.f6188id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
