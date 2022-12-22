package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.dstu;

import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.isEnableDFSync;
import java.io.IOException;
import java.security.SignatureException;

public class SignatureSpiLe extends SignatureSpi {
    /* renamed from: a */
    private static void m2194a(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        byte[] cca_continue = isEnableDFSync.init(super.engineSign()).cca_continue();
        m2194a(cca_continue);
        try {
            return new EdEC(cca_continue).getEncoded();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        try {
            byte[] cca_continue = ((isEnableDFSync) isEnableDFSync.getInstance(bArr)).cca_continue();
            m2194a(cca_continue);
            try {
                return super.engineVerify(new EdEC(cca_continue).getEncoded());
            } catch (SignatureException e) {
                throw e;
            } catch (Exception e2) {
                throw new SignatureException(e2.toString());
            }
        } catch (IOException unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
