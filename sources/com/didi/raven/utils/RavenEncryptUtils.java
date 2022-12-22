package com.didi.raven.utils;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RavenEncryptUtils {
    public static final int SECRET_KEY_LENGTH = 32;

    /* renamed from: a */
    private static final String f33119a = "AES";

    /* renamed from: b */
    private static final Charset f33120b = StandardCharsets.UTF_8;

    /* renamed from: c */
    private static final String f33121c = "0";

    /* renamed from: d */
    private static final String f33122d = "AES/ECB/PKCS7Padding";

    /* renamed from: e */
    private static SecretKey f33123e = null;

    /* renamed from: a */
    private static SecretKey m23330a(String str) throws Exception {
        KeyGenerator instance = KeyGenerator.getInstance(f33119a);
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(str.getBytes("UTF-8"));
        instance.init(128, secureRandom);
        return instance.generateKey();
    }

    public static String encodeWithSHA1(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bytes);
            return m23329a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m23329a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String changeP(String str) {
        String[] strArr = {"B", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "O", "P", "L", "M", "G", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        sb.append(str);
        for (int i2 = 0; i2 < 11; i2++) {
            sb.append(random.nextInt(10));
        }
        StringBuilder sb2 = new StringBuilder();
        char[] charArray = sb.toString().toCharArray();
        int length = charArray.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb2.append(strArr[charArray[i3] - '0']);
        }
        return Base64.encodeToString(sb2.toString().getBytes(), 2);
    }
}
