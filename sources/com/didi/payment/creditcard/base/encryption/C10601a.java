package com.didi.payment.creditcard.base.encryption;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.didi.payment.creditcard.base.encryption.a */
/* compiled from: AES */
class C10601a {
    C10601a() {
    }

    /* renamed from: a */
    public static byte[] m21186a(byte[] bArr, byte[] bArr2) {
        C10603c.m21209a(bArr, "data");
        C10603c.m21209a(bArr2, "key");
        if (bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(new SecretKeySpec(bArr2, "AES").getEncoded(), "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(1, secretKeySpec);
                return instance.doFinal(bArr);
            } catch (Exception e) {
                throw new RuntimeException("encrypt fail!", e);
            }
        } else {
            throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
        }
    }

    /* renamed from: b */
    public static byte[] m21189b(byte[] bArr, byte[] bArr2) {
        C10603c.m21209a(bArr, "data");
        C10603c.m21209a(bArr2, "key");
        if (bArr2.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(new SecretKeySpec(bArr2, "AES").getEncoded(), "AES");
                Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                instance.init(2, secretKeySpec);
                return instance.doFinal(bArr);
            } catch (Exception e) {
                throw new RuntimeException("decrypt fail!", e);
            }
        } else {
            throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
        }
    }

    /* renamed from: a */
    public static String m21184a(String str, String str2) {
        try {
            return new String(C10602b.m21208h(m21186a(str.getBytes("UTF-8"), str2.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /* renamed from: b */
    public static String m21188b(String str, String str2) {
        try {
            return new String(m21189b(C10602b.m21204d(str.getBytes()), str2.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

    /* renamed from: c */
    public static String m21190c(String str, String str2) {
        try {
            return new String(C10602b.m21208h(m21186a(str.getBytes("UTF-8"), C10602b.m21204d(str2.getBytes()))));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /* renamed from: d */
    public static String m21191d(String str, String str2) {
        try {
            return new String(m21189b(C10602b.m21204d(str.getBytes()), C10602b.m21204d(str2.getBytes())), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

    /* renamed from: a */
    public static byte[] m21185a() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES/ECB/PKCS5Padding");
            instance.init(new SecureRandom());
            return instance.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(" getAESKey fail!", e);
        }
    }

    /* renamed from: b */
    public static String m21187b() {
        return new String(C10602b.m21208h(m21185a()));
    }
}
