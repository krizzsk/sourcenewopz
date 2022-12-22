package com.didi.soda.customer.foundation.util;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public final class CipherUtil {

    /* renamed from: a */
    private static final String f41132a = "12345678";

    /* renamed from: b */
    private static final String f41133b = "DES/CBC/PKCS5Padding";

    /* renamed from: c */
    private static Cipher f41134c;

    private CipherUtil() {
    }

    public static String desEncrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher instance = Cipher.getInstance(f41133b);
            instance.init(1, generateSecret, new IvParameterSpec(f41132a.getBytes()));
            return m29187a(instance.doFinal(str2.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String desDecrypt(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher instance = Cipher.getInstance(f41133b);
            instance.init(2, generateSecret, new IvParameterSpec(f41132a.getBytes()));
            return new String(instance.doFinal(m29189b(str2.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b : MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encrypt(String str) {
        SecretKeySpec secretKeySpec = new SecretKeySpec("WsMZmMFHxyJmHYZJLYmyGcaDgZNmhcSY".getBytes(), "AES");
        Cipher a = m29188a();
        if (a == null) {
            return "";
        }
        try {
            a.init(1, secretKeySpec);
            return Base64.encodeToString(a.doFinal(str.getBytes()), 0);
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return "";
        } catch (IllegalBlockSizeException e2) {
            e2.printStackTrace();
            return "";
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String str) {
        Cipher a = m29188a();
        try {
            a.init(2, new SecretKeySpec("WsMZmMFHxyJmHYZJLYmyGcaDgZNmhcSY".getBytes(), "AES"));
            return new String(a.doFinal(Base64.decode(str, 0)), Charset.forName("UTF-8"));
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return "";
        } catch (BadPaddingException e2) {
            e2.printStackTrace();
            return "";
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static Cipher m29188a() {
        if (f41134c == null) {
            try {
                f41134c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
            }
        }
        return f41134c;
    }

    /* renamed from: a */
    private static String m29187a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (bArr != null && i < bArr.length) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            i++;
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    /* renamed from: b */
    private static byte[] m29189b(byte[] bArr) {
        if (bArr.length % 2 == 0) {
            byte[] bArr2 = new byte[(bArr.length / 2)];
            for (int i = 0; i < bArr.length; i += 2) {
                bArr2[i / 2] = (byte) Integer.parseInt(new String(bArr, i, 2), 16);
            }
            return bArr2;
        }
        throw new IllegalArgumentException();
    }
}
