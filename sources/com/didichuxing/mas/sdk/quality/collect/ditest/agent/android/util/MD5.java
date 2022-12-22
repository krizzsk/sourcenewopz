package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import java.security.MessageDigest;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class MD5 {
    public static String encode(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encode16(String str) {
        String encode = encode(str);
        if (encode == null) {
            return null;
        }
        return encode.substring(8, 24);
    }
}
