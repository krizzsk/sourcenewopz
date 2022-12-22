package com.didi.component.business.util;

import android.text.TextUtils;
import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.TimeStyle;
import java.util.Calendar;
import java.util.List;

public class I18NUtils {
    /* renamed from: a */
    private static Elvish m7710a() {
        return Elvish.Companion.getInstance();
    }

    public static String getTimeAllDate(long j) {
        return getTimeAllDate(j, false);
    }

    public static String getTimeAllDate(long j, boolean z) {
        return m7710a().formatDateTime(j / 1000, DateStyle.DATE_DD_MM_YYYY, TimeStyle.TIME_HH_MM, z);
    }

    public static String getMonthDayAndHourMinute(long j) {
        return m7710a().formatDateTime(j / 1000, DateStyle.DATE_DD_MTH, TimeStyle.TIME_HH_MM, false);
    }

    public static String getHourMinute(long j) {
        return m7710a().formatDateTime(j / 1000, DateStyle.NONE, TimeStyle.TIME_HH_MM, false);
    }

    public static String getMonthDay(long j) {
        return m7710a().formatDateTime(j, DateStyle.DATE_DD_MTH, TimeStyle.NONE, true);
    }

    public static String getYearMonthDay(long j) {
        return m7710a().formatDateTime(j / 1000, DateStyle.DATE_DD_MM_YYYY, TimeStyle.NONE, true);
    }

    public static String getMonthDay(long j, boolean z) {
        return m7710a().formatDateTime(j, DateStyle.DATE_DD_MTH, TimeStyle.NONE, z);
    }

    public static String getCurrency(double d, boolean z) {
        if (z) {
            return m7710a().formatCurrency(Double.valueOf(d), false);
        }
        return m7710a().formatNumber(Double.valueOf(d), -1, 1);
    }

    public static String formatDistance(double d, int i) {
        return m7710a().formatDistance(d, DistanceStyle.AUTO, i, false);
    }

    public static List<String> splitDistance(double d, DistanceStyle distanceStyle, int i) {
        return m7710a().splitDistance(d, distanceStyle, i);
    }

    public static Calendar getDateTimeCalendar(long j) {
        return m7710a().getDateTimeCalendar(j);
    }

    public static String getDriverName(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
