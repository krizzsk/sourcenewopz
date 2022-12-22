package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.ByteUtils;
import com.cardinalcommerce.p060a.CardinalEnvironment;
import com.cardinalcommerce.p060a.setImageLevel;
import com.cardinalcommerce.p060a.setImageMatrix;
import com.cardinalcommerce.p060a.setMinWidth;
import com.cardinalcommerce.p060a.valueOf;
import java.nio.ByteBuffer;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCBC {
    public static byte[] configure(SecureRandom secureRandom) {
        byte[] bArr = new byte[ByteUtils.init(128)];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m2216a(SecretKey secretKey, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        try {
            return m2215a(secretKey, true, bArr, provider).doFinal(bArr2);
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static AuthenticatedCipherText Cardinal(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, Provider provider, Provider provider2) throws JOSEException {
        CardinalEnvironment cardinalEnvironment = new CardinalEnvironment(secretKey);
        byte[] a = m2216a(cardinalEnvironment.getInstance, bArr, bArr2, provider);
        byte[] cca_continue = AAD.cca_continue(bArr3);
        return new AuthenticatedCipherText(a, Arrays.copyOf(setImageMatrix.getInstance(cardinalEnvironment.Cardinal, ByteBuffer.allocate(bArr3.length + bArr.length + a.length + cca_continue.length).put(bArr3).put(bArr).put(a).put(cca_continue).array(), provider2), cardinalEnvironment.init));
    }

    /* renamed from: b */
    private static byte[] m2217b(SecretKey secretKey, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        try {
            return m2215a(secretKey, false, bArr, provider).doFinal(bArr2);
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static byte[] cca_continue(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Provider provider, Provider provider2) throws JOSEException {
        CardinalEnvironment cardinalEnvironment = new CardinalEnvironment(secretKey);
        byte[] cca_continue = AAD.cca_continue(bArr3);
        if (valueOf.configure(Arrays.copyOf(setImageMatrix.getInstance(cardinalEnvironment.Cardinal, ByteBuffer.allocate(bArr3.length + bArr.length + bArr2.length + cca_continue.length).put(bArr3).put(bArr).put(bArr2).put(cca_continue).array(), provider2), cardinalEnvironment.init), bArr4)) {
            return m2217b(cardinalEnvironment.getInstance, bArr, bArr2, provider);
        }
        throw new JOSEException("MAC check failed");
    }

    private AESCBC() {
    }

    /* renamed from: a */
    private static Cipher m2215a(SecretKey secretKey, boolean z, byte[] bArr, Provider provider) throws JOSEException {
        Cipher cipher;
        if (provider == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            } catch (Exception e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } else {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", provider);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        if (z) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        return cipher;
    }

    public static AuthenticatedCipherText cca_continue(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, byte[] bArr, byte[] bArr2, Provider provider, Provider provider2) throws JOSEException {
        Base64URL base64URL2;
        byte[] bArr3 = null;
        byte[] cca_continue = jWEHeader.cca_continue.get("epu") instanceof String ? new Base64URL((String) jWEHeader.cca_continue.get("epu")).cca_continue() : null;
        if (jWEHeader.cca_continue.get("epv") instanceof String) {
            bArr3 = new Base64URL((String) jWEHeader.cca_continue.get("epv")).cca_continue();
        }
        byte[] a = m2216a(setImageLevel.cca_continue(secretKey, jWEHeader.init, cca_continue, bArr3), bArr, bArr2, provider);
        SecretKey instance = setImageLevel.getInstance(secretKey, jWEHeader.init, cca_continue, bArr3);
        StringBuilder sb = new StringBuilder();
        if (jWEHeader.getInstance == null) {
            base64URL2 = Base64URL.init(jWEHeader.toString());
        } else {
            base64URL2 = jWEHeader.getInstance;
        }
        sb.append(base64URL2.toString());
        sb.append(".");
        sb.append(base64URL.toString());
        sb.append(".");
        sb.append(Base64URL.cca_continue(bArr).toString());
        sb.append(".");
        sb.append(Base64URL.cca_continue(a));
        return new AuthenticatedCipherText(a, setImageMatrix.getInstance(instance, sb.toString().getBytes(setMinWidth.getInstance), provider2));
    }

    public static byte[] init(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Provider provider, Provider provider2) throws JOSEException {
        Base64URL base64URL5;
        byte[] bArr = null;
        byte[] cca_continue = jWEHeader.cca_continue.get("epu") instanceof String ? new Base64URL((String) jWEHeader.cca_continue.get("epu")).cca_continue() : bArr;
        byte[] cca_continue2 = jWEHeader.cca_continue.get("epv") instanceof String ? new Base64URL((String) jWEHeader.cca_continue.get("epv")).cca_continue() : bArr;
        SecretKey instance = setImageLevel.getInstance(secretKey, jWEHeader.init, cca_continue, cca_continue2);
        StringBuilder sb = new StringBuilder();
        if (jWEHeader.getInstance == null) {
            base64URL5 = Base64URL.init(jWEHeader.toString());
        } else {
            base64URL5 = jWEHeader.getInstance;
        }
        sb.append(base64URL5.toString());
        sb.append(".");
        sb.append(bArr.toString());
        sb.append(".");
        sb.append(base64URL2.toString());
        sb.append(".");
        sb.append(base64URL3.toString());
        if (valueOf.configure(base64URL4.cca_continue(), setImageMatrix.getInstance(instance, sb.toString().getBytes(setMinWidth.getInstance), provider2))) {
            return m2217b(setImageLevel.cca_continue(secretKey, jWEHeader.init, cca_continue, cca_continue2), base64URL2.cca_continue(), base64URL3.cca_continue(), provider);
        }
        throw new JOSEException("MAC check failed");
    }
}
