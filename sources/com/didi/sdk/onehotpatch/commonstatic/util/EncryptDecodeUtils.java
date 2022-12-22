package com.didi.sdk.onehotpatch.commonstatic.util;

import android.text.TextUtils;

public class EncryptDecodeUtils {
    private static final char LOWER_A_ASCII = 'a';
    private static final char LOWER_Z_ASCII = 'z';
    private static final char UPPER_A_ASCII = 'A';
    private static final char UPPER_Z_ASCII = 'Z';

    private static char addLetterAscii(char c) {
        return c == 'Z' ? UPPER_A_ASCII : c == 'z' ? LOWER_A_ASCII : (char) (c + 1);
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private static char reduceLetterAscii(char c) {
        if (c == 'A') {
            return 'Z';
        }
        return c == 'a' ? LOWER_Z_ASCII : (char) (c - 1);
    }

    public static String encrypt(String str) {
        return getStringFromLetterAscii(str, true);
    }

    public static String decode(String str) {
        return getStringFromLetterAscii(str, false);
    }

    private static String getStringFromLetterAscii(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (isLetter(charArray[i])) {
                char c = charArray[i];
                if (z) {
                    sb.append(addLetterAscii(c));
                } else {
                    sb.append(reduceLetterAscii(c));
                }
            } else {
                sb.append(charArray[i] + "");
            }
        }
        return sb.toString();
    }
}
