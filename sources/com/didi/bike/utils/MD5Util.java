package com.didi.bike.utils;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class MD5Util {
    /* renamed from: a */
    private static final char m7278a(int i) {
        return (char) (i < 10 ? i + 48 : (i + 65) - 10);
    }

    private MD5Util() {
    }

    @Deprecated
    public static String md5(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bytes);
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (byte b : digest) {
                stringBuffer.append(Character.forDigit((b & 240) >> 4, 16));
                stringBuffer.append(Character.forDigit(b & Ascii.f53593SI, 16));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (byte b : digest) {
                stringBuffer.append(Character.forDigit((b & 240) >> 4, 16));
                stringBuffer.append(Character.forDigit(b & Ascii.f53593SI, 16));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String strToMD5(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return m7279a(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static String m7279a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
    }

    @Deprecated
    public static String strToMD5_32(String str) {
        return strToMD5(str);
    }

    public static String strToMD5_16(String str) {
        String strToMD5_32 = strToMD5_32(str);
        return (TextUtils.isEmpty(strToMD5_32) || strToMD5_32.length() < 32) ? "" : strToMD5_32.substring(8, 24);
    }

    public static String fileToMD5(File file) {
        if (file == null || !file.isFile()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    } else {
                        String a = m7279a(instance.digest());
                        m7280a((Closeable) fileInputStream2);
                        return a;
                    }
                }
            } catch (Exception e) {
                e = e;
                fileInputStream = fileInputStream2;
                try {
                    e.printStackTrace();
                    m7280a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    m7280a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                m7280a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            m7280a((Closeable) fileInputStream);
            return "";
        }
    }

    /* renamed from: a */
    private static void m7280a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
