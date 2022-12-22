package com.cardinalcommerce.p060a;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* renamed from: com.cardinalcommerce.a.setAnimation */
public final class setAnimation {

    /* renamed from: a */
    private static String f2683a;

    static {
        try {
            f2683a = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
                public final /* synthetic */ Object run() {
                    return System.getProperty("line.separator");
                }
            });
        } catch (Exception unused) {
            try {
                f2683a = String.format("%n", new Object[0]);
            } catch (Exception unused2) {
                f2683a = "\n";
            }
        }
    }

    public static String Cardinal(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) ((c - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    /* renamed from: a */
    private static char[] m1953a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    public static String cca_continue(byte[] bArr) {
        return new String(m1953a(bArr));
    }

    public static byte[] configure(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String getInstance() {
        return f2683a;
    }

    public static String getInstance(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) ((c - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static String init(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int cca_continue = setTransitionName.cca_continue(bArr, cArr);
        if (cca_continue >= 0) {
            return new String(cArr, 0, cca_continue);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }
}
