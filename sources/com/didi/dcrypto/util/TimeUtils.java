package com.didi.dcrypto.util;

import com.didi.sdk.audiorecorder.utils.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {
    public static String getCurrentLocalDateTimeStamp() {
        return new SimpleDateFormat(TimeUtil.YMD_HMSS, Locale.US).format(new Date());
    }
}
