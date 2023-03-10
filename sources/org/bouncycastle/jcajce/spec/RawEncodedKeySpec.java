package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;

public class RawEncodedKeySpec extends EncodedKeySpec {
    public RawEncodedKeySpec(byte[] bArr) {
        super(bArr);
    }

    public String getFormat() {
        return "RAW";
    }
}
