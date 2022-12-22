package com.didi.payment.wallet.global.utils;

import android.graphics.Color;
import com.didi.sdk.util.TextUtil;
import rui.config.RConfigConstants;

public class ColorsUtils {
    public static int parseColor(String str) {
        if (!TextUtil.isEmpty(str) && str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
            try {
                return Color.parseColor(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static int parseColor(String str, String str2) {
        int parseColor = parseColor(str);
        return parseColor == -1 ? parseColor(str2) : parseColor;
    }
}
