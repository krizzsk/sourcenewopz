package com.cardinalcommerce.p060a;

import java.security.spec.EncodedKeySpec;

/* renamed from: com.cardinalcommerce.a.getErrorCode */
public class getErrorCode extends EncodedKeySpec {

    /* renamed from: a */
    private final String f2553a;

    public getErrorCode(byte[] bArr) {
        super(bArr);
        String str;
        if (bArr[0] == 48) {
            str = "ASN.1";
        } else if (bArr[0] == 111) {
            str = "OpenSSH";
        } else {
            throw new IllegalArgumentException("unknown byte encoding");
        }
        this.f2553a = str;
    }

    public String getFormat() {
        return this.f2553a;
    }
}
