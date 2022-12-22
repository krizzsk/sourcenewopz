package com.didi.dynamic.manager.utils;

import android.text.TextUtils;

public class EncryptDecodeUtils {

    /* renamed from: a */
    private static final char f19353a = 'A';

    /* renamed from: b */
    private static final char f19354b = 'Z';

    /* renamed from: c */
    private static final char f19355c = 'a';

    /* renamed from: d */
    private static final char f19356d = 'z';

    /* renamed from: a */
    private static boolean m14475a(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /* renamed from: b */
    private static char m14476b(char c) {
        return c == 'Z' ? f19353a : c == 'z' ? f19355c : (char) (c + 1);
    }

    /* renamed from: c */
    private static char m14477c(char c) {
        if (c == 'A') {
            return 'Z';
        }
        return c == 'a' ? f19356d : (char) (c - 1);
    }

    public static String encrypt(String str) {
        return m14474a(str, true);
    }

    public static String decode(String str) {
        return m14474a(str, false);
    }

    /* renamed from: a */
    private static String m14474a(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (m14475a(charArray[i])) {
                char c = charArray[i];
                if (z) {
                    sb.append(m14476b(c));
                } else {
                    sb.append(m14477c(c));
                }
            } else {
                sb.append(charArray[i] + "");
            }
        }
        return sb.toString();
    }
}
