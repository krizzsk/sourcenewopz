package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.ByteUtils;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Container;
import com.cardinalcommerce.p060a.valueOf;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESGCM {
    public static byte[] Cardinal(SecureRandom secureRandom) {
        byte[] bArr = new byte[12];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m2218a(Cipher cipher) throws JOSEException {
        GCMParameterSpec b = m2219b(cipher);
        byte[] iv = b.getIV();
        int tLen = b.getTLen();
        if (ByteUtils.Cardinal(iv) != 96) {
            throw new JOSEException(String.format("IV length of %d bits is required, got %d", new Object[]{96, Integer.valueOf(ByteUtils.Cardinal(iv))}));
        } else if (tLen == 128) {
            return iv;
        } else {
            throw new JOSEException(String.format("Authentication tag length of %d bits is required, got %d", new Object[]{128, Integer.valueOf(tLen)}));
        }
    }

    /* renamed from: b */
    private static GCMParameterSpec m2219b(Cipher cipher) throws JOSEException {
        AlgorithmParameters parameters = cipher.getParameters();
        if (parameters != null) {
            try {
                return (GCMParameterSpec) parameters.getParameterSpec(GCMParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } else {
            throw new JOSEException("AES GCM ciphers are expected to make use of algorithm parameters");
        }
    }

    private AESGCM() {
    }

    public static AuthenticatedCipherText getInstance(SecretKey secretKey, Container<byte[]> container, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        SecretKeySpec secretKeySpec;
        Cipher cipher;
        if (secretKey == null) {
            secretKeySpec = null;
        } else {
            secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        }
        byte[] bArr3 = (byte[]) container.getInstance;
        if (provider != null) {
            try {
                cipher = Cipher.getInstance("AES/GCM/NoPadding", provider);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
                StringBuilder sb = new StringBuilder("Couldn't create AES/GCM/NoPadding cipher: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            } catch (NoClassDefFoundError unused) {
                return valueOf.init(secretKeySpec, bArr3, bArr, bArr2);
            }
        } else {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
        }
        cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr3));
        cipher.updateAAD(bArr2);
        try {
            byte[] doFinal = cipher.doFinal(bArr);
            int length = doFinal.length - ByteUtils.init(128);
            byte[] instance = ByteUtils.getInstance(doFinal, 0, length);
            byte[] instance2 = ByteUtils.getInstance(doFinal, length, ByteUtils.init(128));
            container.getInstance = m2218a(cipher);
            return new AuthenticatedCipherText(instance, instance2);
        } catch (BadPaddingException | IllegalBlockSizeException e2) {
            StringBuilder sb2 = new StringBuilder("Couldn't encrypt with AES/GCM/NoPadding: ");
            sb2.append(e2.getMessage());
            throw new JOSEException(sb2.toString(), e2);
        }
    }

    public static byte[] init(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Provider provider) throws JOSEException {
        SecretKeySpec secretKeySpec;
        Cipher cipher;
        if (secretKey == null) {
            secretKeySpec = null;
        } else {
            secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        }
        if (provider != null) {
            try {
                cipher = Cipher.getInstance("AES/GCM/NoPadding", provider);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
                StringBuilder sb = new StringBuilder("Couldn't create AES/GCM/NoPadding cipher: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            } catch (NoClassDefFoundError unused) {
                return valueOf.getInstance(secretKeySpec, bArr, bArr2, bArr3, bArr4);
            }
        } else {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
        }
        cipher.init(2, secretKeySpec, new GCMParameterSpec(128, bArr));
        cipher.updateAAD(bArr3);
        try {
            return cipher.doFinal(ByteUtils.getInstance(bArr2, bArr4));
        } catch (BadPaddingException | IllegalBlockSizeException e2) {
            StringBuilder sb2 = new StringBuilder("AES/GCM/NoPadding decryption failed: ");
            sb2.append(e2.getMessage());
            throw new JOSEException(sb2.toString(), e2);
        }
    }
}
