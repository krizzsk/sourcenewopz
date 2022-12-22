package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/* renamed from: com.cardinalcommerce.a.setImageMatrix */
public final class setImageMatrix {
    public final String configure;
    public final int getInstance;

    public setImageMatrix() {
    }

    /* renamed from: a */
    private static Mac m1997a(SecretKey secretKey, Provider provider) throws JOSEException {
        Mac mac;
        if (provider != null) {
            try {
                mac = Mac.getInstance(secretKey.getAlgorithm(), provider);
            } catch (NoSuchAlgorithmException e) {
                StringBuilder sb = new StringBuilder("Unsupported HMAC algorithm: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            } catch (InvalidKeyException e2) {
                StringBuilder sb2 = new StringBuilder("Invalid HMAC key: ");
                sb2.append(e2.getMessage());
                throw new JOSEException(sb2.toString(), e2);
            }
        } else {
            mac = Mac.getInstance(secretKey.getAlgorithm());
        }
        mac.init(secretKey);
        return mac;
    }

    public static byte[] getInstance(SecretKey secretKey, byte[] bArr, Provider provider) throws JOSEException {
        Mac a = m1997a(secretKey, provider);
        a.update(bArr);
        return a.doFinal();
    }

    public setImageMatrix(int i, String str) {
        this.getInstance = i;
        this.configure = str;
    }
}
