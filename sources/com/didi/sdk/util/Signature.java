package com.didi.sdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Signature {

    /* renamed from: a */
    private static final String f37688a = "__x_";

    /* renamed from: b */
    private static final String f37689b = "didiwuxiankejiyouxian2013";

    public static String generateSignature(Map<String, String> map) {
        Object[] array = new ArrayList(map.keySet()).toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder(f37689b);
        for (Object obj : array) {
            String str = (String) obj;
            if (!str.startsWith("__x_")) {
                sb.append(str);
                sb.append(map.get(str));
            }
        }
        sb.append(f37689b);
        try {
            return m26722a(sb.toString());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String generateSignature2(Map<String, Object> map) {
        Object[] array = new ArrayList(map.keySet()).toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder(f37689b);
        for (Object obj : array) {
            String str = (String) obj;
            if (!str.startsWith("__x_")) {
                String valueOf = String.valueOf(map.get(str));
                sb.append(str);
                sb.append(valueOf);
            }
        }
        sb.append(f37689b);
        try {
            return m26722a(sb.toString());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m26722a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m26723a(instance.digest());
    }

    /* renamed from: a */
    private static String m26723a(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str;
    }
}
