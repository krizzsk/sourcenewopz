package com.didi.sdk.audiorecorder.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class TimeUtil {
    public static final String YMD_HMSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /* renamed from: a */
    private static final double f35593a = 1.0E11d;

    public static long currentTimeMillis() {
        long currentTimeMillis = System.currentTimeMillis();
        return ((double) currentTimeMillis) < f35593a ? currentTimeMillis * 1000 : currentTimeMillis;
    }

    public static String formatCurrentTime(String str) {
        return formatTime(currentTimeMillis(), str);
    }

    public static String formatTime(long j, String str) {
        if (TextUtil.isEmpty(str)) {
            return "";
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }
}
