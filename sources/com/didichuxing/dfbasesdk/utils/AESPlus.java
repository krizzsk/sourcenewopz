package com.didichuxing.dfbasesdk.utils;

import com.google.common.base.Ascii;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
public class AESPlus {
    /* renamed from: a */
    private static byte[] m33533a(String str, String str2) throws Exception {
        SecretKeySpec c = m33536c("1f0e64a2ff34d599");
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        instance.init(1, c, new IvParameterSpec(m33535b("F0E1D2C3B4A5968778695A4B3C2D1E0F")));
        byte[] bytes = str2.getBytes("utf-8");
        int length = ((bytes.length + 15) / 16) * 16;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            if (i < bytes.length) {
                bArr[i] = bytes[i];
            } else {
                bArr[i] = 0;
            }
        }
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    private static String m33531a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(r1 * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & Ascii.f53593SI];
        }
        return new String(cArr2);
    }

    public static String encrypt(String str, String str2) {
        byte[] bArr;
        try {
            bArr = m33533a(str, str2);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            bArr = null;
        }
        if (bArr != null) {
            return m33531a(bArr);
        }
        return null;
    }

    public static String decrypt(String str, String str2) {
        try {
            byte[] a = m33532a(str2);
            SecretKeySpec c = m33536c("1f0e64a2ff34d599");
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(2, c, new IvParameterSpec(m33535b("F0E1D2C3B4A5968778695A4B3C2D1E0F")));
            byte[] doFinal = instance.doFinal(a);
            int length = doFinal.length - 1;
            int i = 0;
            while (true) {
                if (i >= doFinal.length) {
                    break;
                } else if (doFinal[i] == 0) {
                    length = i;
                    break;
                } else {
                    i++;
                }
            }
            return new String(Arrays.copyOf(doFinal, length), "utf-8");
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m33532a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (C2382a.f4810a.indexOf(charArray[i2 + 1]) | (C2382a.f4810a.indexOf(charArray[i2]) << 4));
        }
        return bArr;
    }

    /* renamed from: b */
    private static byte m33534b(String str, String str2) {
        return (byte) (((byte) (Byte.decode("0x" + str).byteValue() << 4)) | Byte.decode("0x" + str2).byteValue());
    }

    /* renamed from: b */
    private static byte[] m33535b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = m33534b(str.substring(i2, i3), str.substring(i3, i3 + 1));
        }
        return bArr;
    }

    /* renamed from: c */
    private static SecretKeySpec m33536c(String str) throws Exception {
        byte[] bytes = str.getBytes("utf-8");
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < bytes.length && i < 16) {
            bArr[i] = bytes[i];
            i++;
        }
        return new SecretKeySpec(bArr, "AES");
    }
}
