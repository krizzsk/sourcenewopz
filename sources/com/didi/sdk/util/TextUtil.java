package com.didi.sdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TextUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String ToDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 12288) {
                charArray[i] = ' ';
            } else if (charArray[i] > 65280 && charArray[i] < 65375) {
                charArray[i] = (char) (charArray[i] - 65248);
            }
        }
        return new String(charArray);
    }

    public static boolean isDigit(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return str.matches("^[0-9]*$");
    }
}
