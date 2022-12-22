package com.didi.safety.god.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class FileUtils {
    /* renamed from: a */
    private static String m24566a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
    }

    public static String fileToMD5(File file) {
        MessageDigest instance;
        FileInputStream fileInputStream;
        if (file != null && file.isFile()) {
            FileInputStream fileInputStream2 = null;
            try {
                instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                closeQuietly(fileInputStream2);
                return "";
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileInputStream2);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    } else {
                        String a = m24566a(instance.digest());
                        closeQuietly(fileInputStream);
                        return a;
                    }
                }
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                closeQuietly(fileInputStream2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                closeQuietly(fileInputStream2);
                throw th;
            }
        }
        return "";
    }

    public static String bytesToMD5(byte[] bArr) {
        try {
            return m24566a(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
