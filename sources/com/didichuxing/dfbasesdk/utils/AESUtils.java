package com.didichuxing.dfbasesdk.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class AESUtils {
    public static final String AES_ECB_PKCS5Padding = "AES/ECB/PKCS5Padding";

    /* renamed from: a */
    private static final String f46687a = "UTF-8";

    private AESUtils() {
    }

    public static String aesEncrypt(String str, String str2) throws Exception {
        return Base64Utils.encode(aesEncrypt(str.getBytes("UTF-8"), str2.getBytes("UTF-8")));
    }

    public static byte[] aesEncrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"));
        return instance.doFinal(bArr);
    }

    public static String aesDecrypt(String str, String str2) throws Exception {
        return new String(aesDecrypt(Base64Utils.decode(str), str2.getBytes("UTF-8")), "UTF-8");
    }

    public static byte[] aesDecrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr2, "AES"));
        return instance.doFinal(bArr);
    }
}
