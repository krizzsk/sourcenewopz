package com.didichuxing.nightmode.sdk;

import com.didi.sdk.apm.SystemUtils;
import java.util.Date;
import java.util.Locale;

class NightModeUtils {
    NightModeUtils() {
    }

    static NightModeState getNightModeState(double d, double d2, long j) {
        Date date = new Date(j);
        double d3 = d;
        double d4 = d2;
        double sunriseDate = SunriseSunsetCalculator.getSunriseDate(d3, d4, date.getYear(), date.getMonth(), date.getDay());
        double sunsetDate = SunriseSunsetCalculator.getSunsetDate(d3, d4, date.getYear(), date.getMonth(), date.getDay());
        int timeOffsetInMinutes = NightModeApollo.getTimeOffsetInMinutes();
        double d5 = ((double) timeOffsetInMinutes) / 60.0d;
        double d6 = sunriseDate + d5;
        double d7 = sunsetDate + d5;
        double hours = (double) (((float) date.getHours()) + (((float) ((date.getMinutes() * 60) + date.getSeconds())) / 3600.0f));
        log(String.format(Locale.getDefault(), "NightModeState: [currTime %.3f, sunriseTime %.3f, sunsetTime %.3f, buffer(minutes) %d]", new Object[]{Double.valueOf(hours), Double.valueOf(d6), Double.valueOf(d7), Integer.valueOf(timeOffsetInMinutes)}));
        if (hours < d7) {
            if (hours > d6) {
                return NightModeState.DAY;
            }
            return NightModeState.NIGHT;
        } else if (hours > d6) {
            return NightModeState.NIGHT;
        } else {
            return NightModeState.DAY;
        }
    }

    static double getDoubleFormatTime(long j) {
        Date date = new Date(j);
        return ((double) date.getHours()) + (((double) date.getMinutes()) / 60.0d);
    }

    static void log(String str) {
        SystemUtils.log(3, "NightMode", str, (Throwable) null, "com.didichuxing.nightmode.sdk.NightModeUtils", 56);
    }
}
