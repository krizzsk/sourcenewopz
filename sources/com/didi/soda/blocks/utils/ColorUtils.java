package com.didi.soda.blocks.utils;

import android.graphics.Color;

public class ColorUtils {
    public static int getOpacityFromColor(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        return i2 == 0 ? -2 : -3;
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static int rgba2argb(int i) {
        return ((i >> 8) & 16777215) | (i << 24);
    }

    public static int parseColor(String str) {
        int i;
        try {
            i = Color.parseColor(str);
        } catch (Exception unused) {
            i = 0;
        }
        return str.length() == 9 ? rgba2argb(i) : i;
    }

    public static boolean isColor(String str) {
        if (str.charAt(0) == '#') {
            return str.length() == 7 || str.length() == 9;
        }
        return false;
    }

    public static int[] parseLinearGradientColor(String str) {
        String[] split = str.replace("linear-gradient(", "").replace("deg", "").replace(")", "").trim().split("\\s+");
        int length = split.length;
        int[] iArr = new int[length];
        iArr[0] = Integer.parseInt(split[0]) % 360;
        for (int i = 1; i < length; i++) {
            iArr[i] = parseColor(split[i]);
        }
        return iArr;
    }

    public static boolean isLinearGradientColor(String str) {
        return str.startsWith("linear-gradient");
    }

    public static Object convertColor(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (isColor(str)) {
                return Integer.valueOf(parseColor(str));
            }
            if (isLinearGradientColor(str)) {
                return parseLinearGradientColor(str);
            }
        }
        return 0;
    }
}
