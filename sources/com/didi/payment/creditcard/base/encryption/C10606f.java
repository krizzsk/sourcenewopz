package com.didi.payment.creditcard.base.encryption;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

/* renamed from: com.didi.payment.creditcard.base.encryption.f */
/* compiled from: Digest */
class C10606f {

    /* renamed from: a */
    public static final String f30293a = "UTF-8";

    C10606f() {
    }

    /* renamed from: a */
    public static String m21244a(String str, String str2) {
        try {
            return C10605e.m21227b(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes(str2)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m21243a(String str) {
        try {
            return C10605e.m21227b(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m21247b(String str, String str2) {
        return m21245a(str, str2, "UTF-8");
    }

    /* renamed from: a */
    public static String m21245a(String str, String str2, String str3) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[64];
        try {
            bArr2 = str2.getBytes(str3);
            bArr = str.getBytes(str3);
        } catch (UnsupportedEncodingException unused) {
            bArr2 = str2.getBytes();
            bArr = str.getBytes();
        }
        Arrays.fill(bArr3, bArr2.length, 64, (byte) 54);
        Arrays.fill(bArr4, bArr2.length, 64, (byte) 92);
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ 54);
            bArr4[i] = (byte) (bArr2[i] ^ 92);
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr3);
            instance.update(bArr);
            byte[] digest = instance.digest();
            instance.reset();
            instance.update(bArr4);
            instance.update(digest, 0, 16);
            return C10605e.m21227b(instance.digest());
        } catch (NoSuchAlgorithmException unused2) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m21248b(String str, String str2, String str3) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[64];
        try {
            bArr2 = str2.getBytes(str3);
            bArr = str.getBytes(str3);
        } catch (UnsupportedEncodingException unused) {
            bArr2 = str2.getBytes();
            bArr = str.getBytes();
        }
        Arrays.fill(bArr3, bArr2.length, 64, (byte) 54);
        Arrays.fill(bArr4, bArr2.length, 64, (byte) 92);
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ 54);
            bArr4[i] = (byte) (bArr2[i] ^ 92);
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(bArr3);
            instance.update(bArr);
            byte[] digest = instance.digest();
            instance.reset();
            instance.update(bArr4);
            instance.update(digest, 0, 20);
            return C10605e.m21227b(instance.digest());
        } catch (NoSuchAlgorithmException unused2) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m21246b(String str) {
        return m21250c(str, "UTF-8");
    }

    /* renamed from: c */
    public static String m21250c(String str, String str2) {
        byte[] bArr;
        String trim = str.trim();
        try {
            bArr = trim.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            bArr = trim.getBytes();
        }
        try {
            return C10605e.m21227b(MessageDigest.getInstance("SHA").digest(bArr));
        } catch (NoSuchAlgorithmException unused2) {
            return null;
        }
    }

    /* renamed from: c */
    public static String m21251c(String str, String str2, String str3) {
        byte[] bArr;
        String trim = str.trim();
        try {
            bArr = trim.getBytes(str3);
        } catch (UnsupportedEncodingException unused) {
            bArr = trim.getBytes();
        }
        try {
            return C10605e.m21227b(MessageDigest.getInstance(str2).digest(bArr));
        } catch (NoSuchAlgorithmException unused2) {
            return null;
        }
    }

    /* renamed from: c */
    public static String m21249c(String str) {
        try {
            return new String(C10602b.m21208h(MessageDigest.getInstance("SHA1").digest(str.getBytes(StandardCharsets.UTF_8))), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }
}
