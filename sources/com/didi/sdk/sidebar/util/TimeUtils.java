package com.didi.sdk.sidebar.util;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private TimeUtils() {
        throw new AssertionError();
    }

    public static String getTime(long j, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(new Date(j));
    }

    public static String getTime(long j) {
        return getTime(j, DEFAULT_DATE_FORMAT);
    }

    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    public static String getCurrentTimeInString(SimpleDateFormat simpleDateFormat) {
        return getTime(getCurrentTimeInLong(), simpleDateFormat);
    }

    public static long converDateToMilliSecond(String str) {
        return converDateToMilliSecond(str, DEFAULT_DATE_FORMAT);
    }

    public static long converDateToMilliSecond(String str, String str2) {
        return converDateToMilliSecond(str, new SimpleDateFormat(str2));
    }

    public static long converDateToMilliSecond(String str, SimpleDateFormat simpleDateFormat) {
        if (TextUtil.isEmpty(str)) {
            return -1;
        }
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String[] convertDateTime(Context context, long j, boolean z) {
        String str;
        String str2;
        if (j <= 0) {
            String string = context.getString(R.string.unknown);
            return new String[]{string, string};
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(2) + 1;
        int i2 = instance.get(5);
        int i3 = instance.get(12);
        if (i3 < 0 || i3 >= 10) {
            str = instance.get(11) + ":" + i3;
        } else {
            str = instance.get(11) + ":0" + i3;
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(System.currentTimeMillis());
        if (z || instance.get(1) - instance2.get(1) != 0) {
            str2 = i + context.getString(R.string.month) + i2 + context.getString(R.string.day);
        } else {
            int i4 = instance.get(6) - instance2.get(6);
            if (i4 == -1) {
                str2 = context.getString(R.string.yesterday);
            } else if (i4 == 0) {
                str2 = context.getString(R.string.today);
            } else if (i4 == 1) {
                str2 = context.getString(R.string.tomorrow);
            } else if (i4 != 2) {
                str2 = i + context.getString(R.string.month) + i2 + context.getString(R.string.day);
            } else {
                str2 = context.getString(R.string.acquired);
            }
        }
        return new String[]{str2, str};
    }

    public static String[] convertDateTime(Context context, long j) {
        return convertDateTime(context, j, false);
    }
}
