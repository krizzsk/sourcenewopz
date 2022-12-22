package com.didi.component.payentrance.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    /* renamed from: a */
    private static final String f14967a = "([1-9]\\d*\\.\\d*|0\\.\\d*|[0-9]+)";

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.length() == 0 || trim.equals("null")) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        return isEmpty(charSequence.toString());
    }

    public static boolean equals(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        return str.trim().equals(str2.trim());
    }

    public static String valueOf(float f) {
        if (Float.isNaN(f)) {
            return "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat.format((double) f);
    }

    public static long paseLong(String str) {
        if (isEmpty(str)) {
            return Long.MIN_VALUE;
        }
        try {
            return Long.parseLong(str);
        } catch (ClassCastException unused) {
            return Long.MIN_VALUE;
        }
    }

    public static String getFirstMoneyFromText(String str) {
        if (isEmpty(str)) {
            return "0";
        }
        Matcher matcher = Pattern.compile(f14967a).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "0";
    }
}
