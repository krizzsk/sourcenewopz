package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class SM2ParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: id */
    private byte[] f6257id;

    public SM2ParameterSpec(byte[] bArr) {
        if (bArr != null) {
            this.f6257id = Arrays.clone(bArr);
            return;
        }
        throw new NullPointerException("id string cannot be null");
    }

    public byte[] getID() {
        return Arrays.clone(this.f6257id);
    }
}
