package com.didi.foundation.sdk.utils;

import java.util.Date;
import java.util.TimeZone;

public class LocalizationUtils {
    public static int getTimeZoneUtcOffset(TimeZone timeZone) {
        if (timeZone == null) {
            return -1;
        }
        int rawOffset = timeZone.getRawOffset() / 60000;
        return timeZone.inDaylightTime(new Date()) ? rawOffset + 60 : rawOffset;
    }

    public static int getTimeZoneUtcOffset() {
        return getTimeZoneUtcOffset(TimeZone.getDefault());
    }
}
