package com.didichuxing.mas.sdk.quality.report.analysis;

import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class EncryptUtils {
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDtFHSjIQOJr3hbN/sP/Zs+Mu9l37siyF6Rh7YKI6GJQYehkFfa3YDlFz+09t3QOTPOl5qSvXVYN1TScmcajMvMQA3wZGaUiEbqxugFX9fNHNNATGwWh5l+z6qISpnLagzzdntiwwlwRv8LVGOuSYwB8in5jlwDFvNpAE/0EQW2XQIDAQAB";
    private static final String TAG = "MASSDK_RSA";

    public static String encrypt(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
            PublicKey publicKey = getPublicKey(PUBLIC_KEY);
            if (publicKey == null) {
                return "";
            }
            instance.init(1, publicKey);
            return Base64.encodeToString(instance.doFinal(bArr), 0);
        } catch (Exception e) {
            e.printStackTrace();
            SystemUtils.log(6, TAG, "encrypt failed!", (Throwable) null, "com.didichuxing.mas.sdk.quality.report.analysis.EncryptUtils", 35);
            return "";
        }
    }

    private static PublicKey getPublicKey(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 0)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            SystemUtils.log(6, TAG, "getPublicKey failed!", (Throwable) null, "com.didichuxing.mas.sdk.quality.report.analysis.EncryptUtils", 51);
            return null;
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
            SystemUtils.log(6, TAG, "getPublicKey failed!", (Throwable) null, "com.didichuxing.mas.sdk.quality.report.analysis.EncryptUtils", 51);
            return null;
        }
    }
}
