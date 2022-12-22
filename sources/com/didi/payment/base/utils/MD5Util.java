package com.didi.payment.base.utils;

import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class MD5Util {
    public static final String md5(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bytes);
            return byteArrayToHex(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String fileMD5(File file) throws IOException {
        DigestInputStream digestInputStream;
        FileInputStream fileInputStream;
        String str = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            fileInputStream = new FileInputStream(file);
            try {
                digestInputStream = new DigestInputStream(fileInputStream, instance);
            } catch (Exception e) {
                e = e;
                digestInputStream = null;
                try {
                    e.printStackTrace();
                    FileUtil.closeQuietly(digestInputStream);
                    FileUtil.closeQuietly(fileInputStream);
                    return str;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                digestInputStream = null;
                FileUtil.closeQuietly(digestInputStream);
                FileUtil.closeQuietly(fileInputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[10240];
                for (int read = digestInputStream.read(bArr); read > 0; read = digestInputStream.read(bArr)) {
                }
                str = byteArrayToHex(digestInputStream.getMessageDigest().digest());
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                FileUtil.closeQuietly(digestInputStream);
                FileUtil.closeQuietly(fileInputStream);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            digestInputStream = null;
            fileInputStream = null;
            e.printStackTrace();
            FileUtil.closeQuietly(digestInputStream);
            FileUtil.closeQuietly(fileInputStream);
            return str;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            digestInputStream = null;
            FileUtil.closeQuietly(digestInputStream);
            FileUtil.closeQuietly(fileInputStream);
            throw th;
        }
        FileUtil.closeQuietly(digestInputStream);
        FileUtil.closeQuietly(fileInputStream);
        return str;
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & Ascii.f53593SI];
        }
        return new String(cArr2);
    }
}
