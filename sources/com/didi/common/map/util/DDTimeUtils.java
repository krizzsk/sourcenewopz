package com.didi.common.map.util;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DDTimeUtils {
    public static String formatCurrentTime(String str) {
        return formatTime(currentTimeMillis(), str);
    }

    public static long currentTimeMillis() {
        long currentTimeMillis = System.currentTimeMillis();
        return ((double) currentTimeMillis) < 1.0E11d ? currentTimeMillis * 1000 : currentTimeMillis;
    }

    public static String formatTime(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new SimpleDateFormat(str).format(new Date(j));
    }
}
