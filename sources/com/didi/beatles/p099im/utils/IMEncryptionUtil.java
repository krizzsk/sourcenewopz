package com.didi.beatles.p099im.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

/* renamed from: com.didi.beatles.im.utils.IMEncryptionUtil */
public class IMEncryptionUtil {
    public static String encrypt(String str) {
        return toMD5(str);
    }

    public static String encrypt(long j) {
        return toMD5("" + j);
    }

    public static String encrypt(byte[] bArr) throws Exception {
        return toMD5(bArr);
    }

    public static String toMD5(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(digest[i])}));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String toMD5(byte[] bArr) throws Exception {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        instance.reset();
        instance.update(bArr);
        byte[] digest = instance.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(digest[i])}));
        }
        return stringBuffer.toString();
    }
}
