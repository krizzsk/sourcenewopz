package com.didichuxing.sdk.alphaface.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class FileUtils {
    private FileUtils() {
    }

    /* renamed from: a */
    private static String m35000a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
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
                        String a = m35000a(instance.digest());
                        closeQuietly(fileInputStream2);
                        return a;
                    }
                }
            } catch (Exception e) {
                e = e;
                fileInputStream = fileInputStream2;
                try {
                    AFLog.m34996e(e.getMessage());
                    closeQuietly(fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            AFLog.m34996e(e.getMessage());
            closeQuietly(fileInputStream);
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
