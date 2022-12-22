package com.didi.unifylogin.utils;

import com.didi.sdk.util.SystemUtil;
import com.google.common.base.Ascii;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class LoginDeviceUtil {

    /* renamed from: a */
    private static volatile String f44925a;

    /* renamed from: a */
    private static final char m32214a(int i) {
        return (char) (i < 10 ? i + 48 : (i + 65) - 10);
    }

    public static String getIMEI() {
        return SystemUtil.getIMEI() + m32215a();
    }

    /* renamed from: a */
    private static final String m32215a() {
        String str;
        if (f44925a != null) {
            return f44925a;
        }
        try {
            char[] a = m32216a(Long.valueOf(new File("/system/build.prop").lastModified()).toString());
            if (a == null) {
                str = "";
            } else {
                str = new String(a);
            }
            f44925a = str;
        } catch (Exception unused) {
            f44925a = "";
        }
        return f44925a;
    }

    /* renamed from: a */
    private static final char[] m32216a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length << 1;
            char[] cArr = new char[length];
            byte b = 0;
            for (int i = 0; i < length; i += 2) {
                byte b2 = digest[b] & 255;
                b = (byte) (b + 1);
                if (b2 < 16) {
                    cArr[i] = '0';
                    cArr[i + 1] = m32214a((int) b2);
                } else {
                    cArr[i] = m32214a(b2 >> 4);
                    cArr[i + 1] = m32214a((int) b2 & Ascii.f53593SI);
                }
            }
            return cArr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
