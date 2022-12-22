package com.didi.travel.psnger.utils;

import java.util.TimeZone;

public class TimeUtil {
    public static String getTimeZonID() {
        return TimeZone.getDefault().getID();
    }
}
