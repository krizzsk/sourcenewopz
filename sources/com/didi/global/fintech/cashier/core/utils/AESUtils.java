package com.didi.global.fintech.cashier.core.utils;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

    /* renamed from: a */
    private static final String f21488a = "AES/CBC/PKCS5Padding";

    public static String CbcEncrypt(String str, String str2, String str3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher instance = Cipher.getInstance(f21488a);
        instance.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes(StandardCharsets.UTF_8)));
        return Base64.encodeToString(instance.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2);
    }

    public static String CbcDecrypt(String str, String str2, String str3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher instance = Cipher.getInstance(f21488a);
        instance.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes(StandardCharsets.UTF_8)));
        return new String(instance.doFinal(Base64.decode(str.getBytes(), 2)), StandardCharsets.UTF_8);
    }
}
