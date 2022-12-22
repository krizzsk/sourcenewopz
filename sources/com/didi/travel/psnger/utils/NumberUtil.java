package com.didi.travel.psnger.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {
    public static Double strToDouble(String str) {
        try {
            if (TextUtil.isEmpty(str)) {
                return Double.valueOf(0.0d);
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return Double.valueOf(0.0d);
        }
    }

    public static int strToInt(String str) {
        try {
            if (TextUtil.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static long strToLong(String str) {
        try {
            if (TextUtil.isEmpty(str)) {
                return 0;
            }
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static Float strToFloat(String str) {
        try {
            if (TextUtil.isEmpty(str)) {
                return Float.valueOf(0.0f);
            }
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return Float.valueOf(0.0f);
        }
    }

    public static float roundByDownMode(float f, int i) {
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        return roundByMode(f, i, RoundingMode.DOWN).floatValue();
    }

    public static float roundByHALF_UP(float f, int i) {
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        try {
            return roundByMode(f, i, RoundingMode.HALF_UP).floatValue();
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static BigDecimal roundByMode(float f, int i, RoundingMode roundingMode) {
        return new BigDecimal((double) f).setScale(i, roundingMode);
    }

    public static String changeF2Y(int i) {
        if (i == 0) {
            return "0.0";
        }
        if ((i + "").length() == 1) {
            return "0.0" + (i % 10);
        }
        int i2 = i % 100;
        if (i2 < 10) {
            return (i / 100) + ".0" + i2;
        }
        return (i / 100) + "." + i2;
    }

    public static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static float parseFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return 0.0f;
        }
    }
}
