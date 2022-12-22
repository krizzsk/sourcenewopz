package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.cardinalcommerce.a.setImageLevel */
public final class setImageLevel {

    /* renamed from: a */
    private static final byte[] f2812a = {0, 0, 0, 1};

    /* renamed from: b */
    private static final byte[] f2813b = {0, 0, 0, 0};

    /* renamed from: c */
    private static final byte[] f2814c = {69, 110, 99, 114, 121, 112, 116, 105, 111, 110};

    /* renamed from: d */
    private static final byte[] f2815d = {73, 110, 116, 101, 103, 114, 105, 116, 121};

    public static SecretKey cca_continue(SecretKey secretKey, EncryptionMethod encryptionMethod, byte[] bArr, byte[] bArr2) throws JOSEException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(f2812a);
            byte[] encoded = secretKey.getEncoded();
            byteArrayOutputStream.write(encoded);
            int length = encoded.length << 3;
            byteArrayOutputStream.write(valueOf.configure(length / 2));
            byteArrayOutputStream.write(encryptionMethod.toString().getBytes(setMinWidth.getInstance));
            if (bArr != null) {
                byteArrayOutputStream.write(valueOf.configure(bArr.length));
                byteArrayOutputStream.write(bArr);
            } else {
                byteArrayOutputStream.write(f2813b);
            }
            if (bArr2 != null) {
                byteArrayOutputStream.write(valueOf.configure(bArr2.length));
                byteArrayOutputStream.write(bArr2);
            } else {
                byteArrayOutputStream.write(f2813b);
            }
            byteArrayOutputStream.write(f2814c);
            try {
                byte[] digest = MessageDigest.getInstance("SHA-".concat(String.valueOf(length))).digest(byteArrayOutputStream.toByteArray());
                int length2 = digest.length / 2;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(digest, 0, bArr3, 0, length2);
                return new SecretKeySpec(bArr3, "AES");
            } catch (NoSuchAlgorithmException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } catch (IOException e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    public static SecretKey getInstance(SecretKey secretKey, EncryptionMethod encryptionMethod, byte[] bArr, byte[] bArr2) throws JOSEException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(f2812a);
            byte[] encoded = secretKey.getEncoded();
            byteArrayOutputStream.write(encoded);
            int length = encoded.length << 3;
            byteArrayOutputStream.write(valueOf.configure(length));
            byteArrayOutputStream.write(encryptionMethod.toString().getBytes(setMinWidth.getInstance));
            if (bArr != null) {
                byteArrayOutputStream.write(valueOf.configure(bArr.length));
                byteArrayOutputStream.write(bArr);
            } else {
                byteArrayOutputStream.write(f2813b);
            }
            if (bArr2 != null) {
                byteArrayOutputStream.write(valueOf.configure(bArr2.length));
                byteArrayOutputStream.write(bArr2);
            } else {
                byteArrayOutputStream.write(f2813b);
            }
            byteArrayOutputStream.write(f2815d);
            try {
                return new SecretKeySpec(MessageDigest.getInstance("SHA-".concat(String.valueOf(length))).digest(byteArrayOutputStream.toByteArray()), "HMACSHA".concat(String.valueOf(length)));
            } catch (NoSuchAlgorithmException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } catch (IOException e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }
}
