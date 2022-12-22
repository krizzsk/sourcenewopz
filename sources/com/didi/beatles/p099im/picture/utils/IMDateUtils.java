package com.didi.beatles.p099im.picture.utils;

import java.text.SimpleDateFormat;

/* renamed from: com.didi.beatles.im.picture.utils.IMDateUtils */
public class IMDateUtils {

    /* renamed from: a */
    private static SimpleDateFormat f9450a = new SimpleDateFormat("mm:ss");

    public static String timeParse(long j) {
        if (j > 1000) {
            return timeParseMinute(j);
        }
        long j2 = j / 60000;
        long round = (long) Math.round(((float) (j % 60000)) / 1000.0f);
        String str = (j2 < 10 ? "0" : "") + j2 + ":";
        if (round < 10) {
            str = str + "0";
        }
        return str + round;
    }

    public static String timeParseMinute(long j) {
        try {
            return f9450a.format(Long.valueOf(j));
        } catch (Exception e) {
            e.printStackTrace();
            return "0:00";
        }
    }

    public static int dateDiffer(long j) {
        try {
            return (int) Math.abs(Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(0, 10)) - j);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String cdTime(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > 1000) {
            return (j3 / 1000) + "秒";
        }
        return j3 + "毫秒";
    }
}
