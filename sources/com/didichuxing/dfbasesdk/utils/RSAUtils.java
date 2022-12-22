package com.didichuxing.dfbasesdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public final class RSAUtils {
    public static final int KEY_SIZE = 1024;

    public static PublicKey getPublicKey(String str) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Utils.decode(str)));
    }

    public static PrivateKey getPrivateKey(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64Utils.decode(str)));
    }

    public static String encipher(String str, String str2) throws Exception {
        return encipher(str, str2, 117);
    }

    public static String encipher(byte[] bArr, String str) throws Exception {
        return encipher(bArr, str, 117);
    }

    public static String encipher(String str, String str2, int i) throws Exception {
        return encipher(str, (Key) getPublicKey(str2), i);
    }

    public static String encipher(byte[] bArr, String str, int i) throws Exception {
        return encipher(bArr, (Key) getPublicKey(str), i);
    }

    public static String encipher(String str, Key key, int i) throws Exception {
        return encipher(str.getBytes("UTF-8"), key, i);
    }

    public static String encipher(byte[] bArr, Key key, int i) throws Exception {
        byte[] bArr2;
        Cipher instance = Cipher.getInstance(C10604d.f30291c);
        instance.init(1, key);
        if (i > 0) {
            bArr2 = cipherDoFinal(instance, bArr, i);
        } else {
            bArr2 = instance.doFinal(bArr);
        }
        return Base64Utils.encode(bArr2);
    }

    public static byte[] cipherDoFinal(Cipher cipher, byte[] bArr, int i) throws IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] bArr2;
        if (i > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = length - i2;
                if (i4 > 0) {
                    if (i4 > i) {
                        bArr2 = cipher.doFinal(bArr, i2, i);
                    } else {
                        bArr2 = cipher.doFinal(bArr, i2, i4);
                    }
                    byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                    i3++;
                    i2 = i3 * i;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } else {
            throw new RuntimeException("分段大小必须大于0");
        }
    }

    public static String decipher(String str, String str2) throws Exception {
        return decipher(str, str2, 128);
    }

    public static byte[] decipherToBytes(String str, String str2) throws Exception {
        return decipherToBytes(str, str2, 128);
    }

    public static String decipher(String str, String str2, int i) throws Exception {
        return decipher(str, (Key) getPrivateKey(str2), i);
    }

    public static byte[] decipherToBytes(String str, String str2, int i) throws Exception {
        return decipherToBytes(str, (Key) getPrivateKey(str2), i);
    }

    public static String decipher(String str, Key key, int i) throws Exception {
        return new String(decipherToBytes(str, key, i), "UTF-8");
    }

    public static byte[] decipherToBytes(String str, Key key, int i) throws Exception {
        byte[] decode = Base64Utils.decode(str);
        Cipher instance = Cipher.getInstance(C10604d.f30291c);
        instance.init(2, key);
        if (i > 0) {
            return cipherDoFinal(instance, decode, i);
        }
        return instance.doFinal(decode);
    }
}
