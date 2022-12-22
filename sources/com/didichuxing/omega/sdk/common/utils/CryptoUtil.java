package com.didichuxing.omega.sdk.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {
    private static final String SLATKEY = "wYDJty8o8HE6YjJS";
    private static Cipher cipher;

    private static Cipher getCipher(int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SLATKEY.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(i, secretKeySpec);
            return instance;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr) {
        try {
            return getCipher(1).doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr) {
        try {
            return getCipher(2).doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }
}
