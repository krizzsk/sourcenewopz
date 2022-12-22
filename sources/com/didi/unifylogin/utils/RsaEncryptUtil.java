package com.didi.unifylogin.utils;

import android.content.Context;
import android.util.Base64;
import com.didi.sdk.util.AssetsUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RsaEncryptUtil {
    public static final String TAG = "RsaEncryptUtil";

    public static String getRSAData(Context context, String str) {
        try {
            return encryptRSAToString(str, AssetsUtil.getAssetsFile(context, "rsa_public_key.pem"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptByPublicKey(byte[] bArr, byte[] bArr2) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
        instance.init(1, generatePublic);
        return instance.doFinal(bArr);
    }

    public static String encryptRSAToString(String str, String str2) {
        String str3;
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2.trim().getBytes(), 0)));
            Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
            instance.init(1, generatePublic);
            str3 = new String(Base64.encode(instance.doFinal(str.getBytes("UTF-8")), 0));
        } catch (Exception e) {
            e.printStackTrace();
            str3 = "";
        }
        return str3.replaceAll("(\\r|\\n)", "");
    }
}
