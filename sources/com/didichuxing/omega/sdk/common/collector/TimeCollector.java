package com.didichuxing.omega.sdk.common.collector;

import android.os.SystemClock;
import java.util.Date;
import java.util.TimeZone;

public class TimeCollector {
    private static long mAppStartTime;
    private static int utcOffset;

    public static void init() {
        mAppStartTime = System.currentTimeMillis();
    }

    public static int getTimeZoneUtcOffset() {
        if (utcOffset == 0) {
            setTimeZoneUtcOffset();
        }
        return utcOffset;
    }

    private static void setTimeZoneUtcOffset() {
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone != null) {
            int rawOffset = timeZone.getRawOffset() / 60000;
            if (timeZone.inDaylightTime(new Date())) {
                rawOffset += 60;
            }
            utcOffset = rawOffset;
        }
    }

    public static long getAppStartupTime() {
        if (mAppStartTime == 0) {
            return 0;
        }
        return System.currentTimeMillis() - mAppStartTime;
    }

    public static long getSysStartupTime() {
        return SystemClock.elapsedRealtime();
    }
}
