package com.didi.app.nova.support.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public final class TimeUtils {
    public static final String DATE_FORMAT_TYPE_1 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_TYPE_2 = "HH:mm";
    public static final String DATE_FORMAT_TYPE_3 = "yyyyMMdd";
    public static final String DATE_FORMAT_TYPE_4 = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String DATE_FORMAT_TYPE_5 = "MM月dd日";
    public static final String DATE_FORMAT_TYPE_6 = "yyyy年MM月dd日 HH:mm";
    public static final String DATE_FORMAT_TYPE_7 = "yyyy年MM月dd日";
    public static final long MILLISECOND_IN_ONE_SECOND = 1000;
    public static final int SECOND_IN_ONE_DAY = 86400;
    public static final int SECOND_IN_ONE_MINUTE = 60;
    public static final String SEPARATOR_COLON = ":";
    public static final String SEPARATOR_LINE = "-";

    /* renamed from: a */
    private static long f8546a;

    private TimeUtils() {
    }

    public static String secondToHourMinutes(long j) {
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        StringBuffer stringBuffer = new StringBuffer();
        if (j2 > 0) {
            stringBuffer.append(j2);
            stringBuffer.append("小时");
        }
        stringBuffer.append(j3);
        stringBuffer.append("分钟");
        return stringBuffer.toString();
    }

    public static String secondToMinuteString(long j, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(j) / 60);
        sb.append("分钟");
        if (z) {
            long abs = Math.abs(j) % 60;
            if (abs > 0) {
                sb.append(abs);
                sb.append("秒");
            }
        }
        return sb.toString();
    }

    public static void syncTime(long j) {
        if (j != 0) {
            f8546a = (System.currentTimeMillis() / 1000) - j;
        }
    }

    public static long currentTime() {
        return (System.currentTimeMillis() / 1000) - f8546a;
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis() - (f8546a * 1000);
    }

    public static String convertSecToDate(long j, String str) {
        return convertMillSecToDate(j * 1000, str);
    }

    public static String convertMillSecToDate(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static long strHHMMToMillSeconds(String str) {
        try {
            String[] split = str.split(":");
            if (split.length <= 1) {
                return 0;
            }
            return ((long) (((Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1])) * 60)) * 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long strHHMMToMinutes(String str) {
        try {
            String[] split = str.split(":");
            if (split.length <= 1) {
                return 0;
            }
            return (long) ((Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getCurrentDayMillSeconds() {
        Calendar instance = Calendar.getInstance();
        return ((long) (((instance.get(11) * 60) + instance.get(12)) * 60)) * 1000;
    }

    public static ArrayList<String> getLastSevenDay(String str) {
        long currentTime = currentTime();
        ArrayList<String> arrayList = new ArrayList<>(7);
        int i = 0;
        while (i < 7) {
            i++;
            arrayList.add(convertSecToDate(currentTime - ((long) (86400 * i)), str));
        }
        return arrayList;
    }

    public static long parseDateToSecond(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
