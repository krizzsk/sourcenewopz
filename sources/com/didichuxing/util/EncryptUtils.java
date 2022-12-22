package com.didichuxing.util;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptUtils {

    /* renamed from: a */
    private static final String f49246a = "UpgradeSDK_RSA";

    /* renamed from: b */
    private static final String f49247b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDtFHSjIQOJr3hbN/sP/Zs+Mu9l37siyF6Rh7YKI6GJQYehkFfa3YDlFz+09t3QOTPOl5qSvXVYN1TScmcajMvMQA3wZGaUiEbqxugFX9fNHNNATGwWh5l+z6qISpnLagzzdntiwwlwRv8LVGOuSYwB8in5jlwDFvNpAE/0EQW2XQIDAQAB";

    public static String encrypt(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
            PublicKey a = m35518a(f49247b);
            if (a == null) {
                return "";
            }
            instance.init(1, a);
            return Base64.encodeToString(instance.doFinal(bArr), 0);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            UpLogger.m35522d(f49246a, "encrypt failed!");
            return "";
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            UpLogger.m35522d(f49246a, "encrypt failed!");
            return "";
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            UpLogger.m35522d(f49246a, "encrypt failed!");
            return "";
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            UpLogger.m35522d(f49246a, "encrypt failed!");
            return "";
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            UpLogger.m35522d(f49246a, "encrypt failed!");
            return "";
        }
    }

    /* renamed from: a */
    private static PublicKey m35518a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 0)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            UpLogger.m35522d(f49246a, "getPublicKey failed!");
            return null;
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
            UpLogger.m35522d(f49246a, "getPublicKey failed!");
            return null;
        }
    }
}
