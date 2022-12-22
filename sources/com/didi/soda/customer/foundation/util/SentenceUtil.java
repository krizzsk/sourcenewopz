package com.didi.soda.customer.foundation.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SentenceUtil {
    public static final String SEPARATOR_COMMA = ",";
    public static final String SEPARATOR_UNDERLINE = "_";

    private SentenceUtil() {
    }

    public static String getGapFormatStr(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 == 0 || i2 % i != 0) {
                sb.append(charArray[i2]);
            } else {
                sb.append(" ");
                sb.append(charArray[i2]);
            }
        }
        return sb.toString();
    }

    public static String foldStringList(List<String> list, String str) {
        if (CollectionsUtil.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
            sb.append(str);
        }
        return sb.substring(0, sb.length() - str.length());
    }

    public static List<String> unFoldString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new ArrayList(Arrays.asList(str.split(str2)));
    }
}
