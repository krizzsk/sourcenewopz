package com.didi.sdk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String formatDate(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    public static String formatDateInSimple(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }

    public static String formateTime(long j) {
        return new SimpleDateFormat("aa HH:mm").format(new Date(j));
    }

    public static boolean isOutOfDate(long j, int i) {
        return System.currentTimeMillis() - j > ((long) (((i * 60) * 60) * 1000));
    }

    public static boolean isOutOfDate(String str, int i) {
        return System.currentTimeMillis() - Long.valueOf(str).longValue() > ((long) (((i * 60) * 60) * 1000));
    }

    public static Date parseString(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
