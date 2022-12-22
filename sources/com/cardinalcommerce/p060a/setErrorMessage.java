package com.cardinalcommerce.p060a;

import com.google.common.base.Ascii;
import java.security.spec.EncodedKeySpec;

/* renamed from: com.cardinalcommerce.a.setErrorMessage */
public class setErrorMessage extends EncodedKeySpec {

    /* renamed from: a */
    private static final String[] f2765a = {"ssh-rsa", "ssh-ed25519", "ssh-dss"};

    /* renamed from: b */
    private final String f2766b;

    public setErrorMessage(byte[] bArr) {
        super(bArr);
        int i = 0;
        int i2 = (((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) + 4;
        if (i2 < bArr.length) {
            String cca_continue = setAnimation.cca_continue(setForegroundTintBlendMode.cca_continue(bArr, 4, i2));
            this.f2766b = cca_continue;
            if (!cca_continue.startsWith("ecdsa")) {
                while (true) {
                    String[] strArr = f2765a;
                    if (i >= strArr.length) {
                        StringBuilder sb = new StringBuilder("unrecognised public key type ");
                        sb.append(this.f2766b);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (!strArr[i].equals(this.f2766b)) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
        }
    }

    public String getFormat() {
        return "OpenSSH";
    }
}
