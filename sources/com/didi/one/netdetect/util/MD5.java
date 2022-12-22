package com.didi.one.netdetect.util;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class MD5 {
    public static String computeMD5(InputStream inputStream) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return new BigInteger(1, instance.digest()).toString(16);
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
