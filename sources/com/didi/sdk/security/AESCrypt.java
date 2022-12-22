package com.didi.sdk.security;

import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AESCrypt {
    public static boolean DEBUG_LOG_ENABLED = false;

    /* renamed from: a */
    private static final String f37152a = "AESCrypt";

    /* renamed from: b */
    private static final String f37153b = "AES/CBC/PKCS7Padding";

    /* renamed from: c */
    private static final String f37154c = "UTF-8";

    /* renamed from: d */
    private static final String f37155d = "SHA-256";

    /* renamed from: e */
    private static final byte[] f37156e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a */
    private static SecretKeySpec m26333a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        byte[] digest = instance.digest();
        m26335a("SHA-256 key ", digest);
        return new SecretKeySpec(digest, "AES");
    }

    public static String encrypt(String str, String str2) throws GeneralSecurityException {
        try {
            return Base64.encodeToString(encrypt(new SecretKeySpec(Base64.decode(str, 0), "AES"), f37156e, str2.getBytes("UTF-8")), 2);
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                SystemUtils.log(6, f37152a, "UnsupportedEncodingException ", e, "com.didi.sdk.security.AESCrypt", 78);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] encrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance(f37153b);
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        m26335a("cipherText", doFinal);
        return doFinal;
    }

    public static String decrypt(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a = m26333a(str);
            m26334a("base64EncodedCipherText", str2);
            byte[] decode = Base64.decode(str2, 2);
            m26335a("decodedCipherText", decode);
            byte[] decrypt = decrypt(a, f37156e, decode);
            m26335a("decryptedBytes", decrypt);
            String str3 = new String(decrypt, "UTF-8");
            m26334a("message", str3);
            return str3;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                SystemUtils.log(6, f37152a, "UnsupportedEncodingException ", e, "com.didi.sdk.security.AESCrypt", 134);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] decrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance(f37153b);
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        m26335a("decryptedBytes", doFinal);
        return doFinal;
    }

    /* renamed from: a */
    private static void m26335a(String str, byte[] bArr) {
        if (DEBUG_LOG_ENABLED) {
            SystemUtils.log(3, f37152a, str + Const.jaLeft + bArr.length + "] [" + m26332a(bArr) + Const.jaRight, (Throwable) null, "com.didi.sdk.security.AESCrypt", 165);
        }
    }

    /* renamed from: a */
    private static void m26334a(String str, String str2) {
        if (DEBUG_LOG_ENABLED) {
            SystemUtils.log(3, f37152a, str + Const.jaLeft + str2.length() + "] [" + str2 + Const.jaRight, (Throwable) null, "com.didi.sdk.security.AESCrypt", 170);
        }
    }

    /* renamed from: a */
    private static String m26332a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            cArr2[i2] = cArr[b >>> 4];
            cArr2[i2 + 1] = cArr[b & Ascii.f53593SI];
        }
        return new String(cArr2);
    }

    private AESCrypt() {
    }
}
