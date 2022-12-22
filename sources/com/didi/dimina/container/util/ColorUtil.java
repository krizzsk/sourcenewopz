package com.didi.dimina.container.util;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.graphics.ColorKt;
import java.util.regex.Pattern;
import rui.config.RConfigConstants;

public class ColorUtil {
    public static boolean isValidColorStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})|#[0-9a-fA-F]{3}$", str);
    }

    public static String convert3To6(String str) {
        if (str.length() != 4) {
            return str;
        }
        String substring = str.substring(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substring.length(); i++) {
            char charAt = substring.charAt(i);
            sb.append(charAt);
            sb.append(charAt);
        }
        return RConfigConstants.KEYWORD_COLOR_SIGN + sb.toString();
    }

    public static int parseColor(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || str.length() > 4) {
                return Color.parseColor(str);
            }
            return Color.parseColor(convert3To6(str));
        } catch (Exception e) {
            e.printStackTrace();
            return Color.parseColor(str2);
        }
    }

    public static int rgbaToArgb(String str, String str2) {
        try {
            if (!isValidColorStr(str) || str.length() < 8) {
                return parseColor(str, str2);
            }
            int parseColor = Color.parseColor(str);
            return Color.argb(ColorKt.getBlue(parseColor), ColorKt.getAlpha(parseColor), ColorKt.getRed(parseColor), ColorKt.getGreen(parseColor));
        } catch (Exception e) {
            e.printStackTrace();
            return Color.parseColor(str2);
        }
    }
}
