package com.didi.soda.customer.p165h5.hybird.tool;

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

/* renamed from: com.didi.soda.customer.h5.hybird.tool.WebEncryptUtil */
public class WebEncryptUtil {

    /* renamed from: a */
    private static final String f41331a = "0CA4DA22BA2C33C8";

    /* renamed from: b */
    private static final String f41332b = "9A47E3ED787A8F27";

    public static String aesEncrypt(String str) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f41332b.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(f41331a.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return null;
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
