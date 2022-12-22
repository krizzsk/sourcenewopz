package com.didi.sofa.utils;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class MD5Utils {

    /* renamed from: a */
    private static final String f43954a = "MD5Utils";

    public static boolean checkMD5(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            SystemUtils.log(6, f43954a, "MD5Utils string empty or updateFile null", (Throwable) null, "com.didi.sofa.utils.MD5Utils", 28);
            return false;
        }
        String calculateMD5 = calculateMD5(file);
        if (calculateMD5 == null) {
            SystemUtils.log(6, f43954a, "calculatedDigest null", (Throwable) null, "com.didi.sofa.utils.MD5Utils", 34);
            return false;
        }
        SystemUtils.log(2, f43954a, "Calculated digest: " + calculateMD5, (Throwable) null, "com.didi.sofa.utils.MD5Utils", 38);
        SystemUtils.log(2, f43954a, "Provided digest: " + str, (Throwable) null, "com.didi.sofa.utils.MD5Utils", 39);
        return calculateMD5.equalsIgnoreCase(str);
    }

    public static String calculateMD5(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5Utils", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            SystemUtils.log(6, f43954a, "Exception on closing MD5Utils input stream", e2, "com.didi.sofa.utils.MD5Utils", 79);
                        }
                        throw th;
                    }
                }
                String replace = String.format("%32s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    SystemUtils.log(6, f43954a, "Exception on closing MD5Utils input stream", e3, "com.didi.sofa.utils.MD5Utils", 79);
                }
                return replace;
            } catch (FileNotFoundException e4) {
                SystemUtils.log(6, f43954a, "Exception while getting FileInputStream", e4, "com.didi.sofa.utils.MD5Utils", 57);
                return null;
            }
        } catch (NoSuchAlgorithmException e5) {
            SystemUtils.log(6, f43954a, "Exception while getting digest", e5, "com.didi.sofa.utils.MD5Utils", 49);
            return null;
        }
    }
}
