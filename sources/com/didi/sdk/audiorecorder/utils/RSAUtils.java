package com.didi.sdk.audiorecorder.utils;

import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public abstract class RSAUtils {

    /* renamed from: a */
    private static final String f35586a = "RSA";

    public static byte[] encryptByPublicKey(byte[] bArr, String str) throws Exception {
        byte[] decode = Base64Utils.decode(str);
        Cipher instance = Cipher.getInstance(C10604d.f30291c);
        instance.init(1, KeyFactory.getInstance(f35586a).generatePublic(new X509EncodedKeySpec(decode)));
        return instance.doFinal(bArr);
    }
}
