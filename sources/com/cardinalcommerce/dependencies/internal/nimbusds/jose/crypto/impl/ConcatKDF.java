package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.ByteUtils;
import com.cardinalcommerce.p060a.setColorFilter;
import com.cardinalcommerce.p060a.setImageAlpha;
import com.cardinalcommerce.p060a.valueOf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ConcatKDF implements setImageAlpha<setColorFilter> {

    /* renamed from: a */
    private final String f3245a;

    /* renamed from: b */
    private final setColorFilter f3246b = new setColorFilter();

    public static byte[] getInstance() {
        return new byte[0];
    }

    public ConcatKDF(String str) {
        this.f3245a = str;
    }

    public final setColorFilter Cardinal() {
        return this.f3246b;
    }

    public final SecretKey Cardinal(SecretKey secretKey, int i, byte[] bArr) throws JOSEException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MessageDigest a = m2221a();
        int i2 = 1;
        while (true) {
            int configure = ByteUtils.configure(a.getDigestLength());
            if (i2 > ((configure + 256) - 1) / configure) {
                break;
            }
            a.update(valueOf.configure(i2));
            a.update(secretKey.getEncoded());
            if (bArr != null) {
                a.update(bArr);
            }
            try {
                byteArrayOutputStream.write(a.digest());
                i2++;
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder("Couldn't write derived key: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int init = ByteUtils.init(256);
        if (byteArray.length == init) {
            return new SecretKeySpec(byteArray, "AES");
        }
        return new SecretKeySpec(ByteUtils.getInstance(byteArray, 0, init), "AES");
    }

    public static byte[] Cardinal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        return ByteUtils.getInstance(bArr, bArr2, bArr3, bArr4, bArr5);
    }

    public static byte[] init() {
        return valueOf.configure(256);
    }

    public static byte[] cca_continue() {
        return m2222a((byte[]) null);
    }

    /* renamed from: a */
    private static byte[] m2222a(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return ByteUtils.getInstance(valueOf.configure(bArr.length), bArr);
    }

    public static byte[] configure(Base64URL base64URL) {
        return m2222a(base64URL != null ? base64URL.cca_continue() : null);
    }

    /* renamed from: a */
    private MessageDigest m2221a() throws JOSEException {
        Provider provider = this.f3246b.Cardinal;
        if (provider != null) {
            return MessageDigest.getInstance(this.f3245a, provider);
        }
        try {
            return MessageDigest.getInstance(this.f3245a);
        } catch (NoSuchAlgorithmException e) {
            StringBuilder sb = new StringBuilder("Couldn't get message digest for KDF: ");
            sb.append(e.getMessage());
            throw new JOSEException(sb.toString(), e);
        }
    }
}
