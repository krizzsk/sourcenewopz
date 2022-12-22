package com.didi.sofa.utils;

import android.content.Context;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static final String HOUR = "HH:mm";
    public static final String YEAR_HOUR = "yyyy.MM.dd HH:mm";

    /* renamed from: a */
    private static long f43963a;

    public static String[] convertDateTime(Context context, long j) {
        String str;
        if (j <= 0) {
            return new String[]{"", ""};
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(2) + 1;
        int i2 = instance.get(5);
        int i3 = instance.get(12);
        if (i3 < 0 || i3 >= 10) {
            str = String.valueOf(instance.get(11)) + ":" + i3;
        } else {
            str = String.valueOf(instance.get(11)) + ":0" + i3;
        }
        Calendar.getInstance().setTimeInMillis(System.currentTimeMillis());
        return new String[]{String.valueOf(i) + "-" + i2, str};
    }

    public static String getFormatTime(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public static String getYesterday() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(new Date().getTime() - 86400000));
    }

    public static String getDateEN() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static String getDateMS() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").format(new Date(System.currentTimeMillis()));
    }

    public static long currentTimeMillis() {
        long currentTimeMillis = System.currentTimeMillis();
        return ((double) currentTimeMillis) < 1.0E11d ? currentTimeMillis * 1000 : currentTimeMillis;
    }

    public static long currentTimeSeconds() {
        long currentTimeMillis = System.currentTimeMillis();
        return ((double) currentTimeMillis) > 1.0E11d ? currentTimeMillis / 1000 : currentTimeMillis;
    }

    public static boolean isToday(long j) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(1, instance.get(1));
        instance2.set(2, instance.get(2));
        instance2.set(5, instance.get(5));
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance.setTimeInMillis(j);
        return instance.after(instance2);
    }

    public static String format(long j) {
        StringBuilder sb;
        StringBuilder sb2;
        long j2 = (long) 86400;
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        long j5 = (long) 3600;
        long j6 = j4 / j5;
        long j7 = j4 - (j5 * j6);
        long j8 = (long) 60;
        long j9 = j7 / j8;
        long j10 = j7 - (j8 * j9);
        long j11 = (long) 1;
        long j12 = j10 / j11;
        long j13 = j10 - (j11 * j12);
        int i = (j3 > 10 ? 1 : (j3 == 10 ? 0 : -1));
        StringBuilder sb3 = j6 < 10 ? new StringBuilder() : new StringBuilder();
        sb3.append("");
        sb3.append(j6);
        String sb4 = sb3.toString();
        if (j9 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j9);
        String sb5 = sb.toString();
        int i2 = (j12 > 10 ? 1 : (j12 == 10 ? 0 : -1));
        if (j13 < 10) {
            sb2.append("0");
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j13);
        sb2.toString();
        int i3 = (j13 > 100 ? 1 : (j13 == 100 ? 0 : -1));
        return sb4 + ":" + sb5;
    }

    public static String formatHour(long j) {
        return new BigDecimal(((double) (((float) j) * 1.0f)) / ((double) 3600)).setScale(1, 5).toString();
    }

    public static boolean isNewDay(long j) {
        return !m31301a(j).equals(m31301a(System.currentTimeMillis()));
    }

    /* renamed from: a */
    private static String m31301a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
        } catch (Exception unused) {
            return "";
        }
    }
}
