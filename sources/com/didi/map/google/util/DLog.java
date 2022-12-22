package com.didi.map.google.util;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class DLog {
    private static final Logger mLogger = LoggerFactory.getLogger("map_group", "map");

    /* renamed from: d */
    public static void m19914d(String str, String str2, Object... objArr) {
        try {
            String format = String.format(str2, objArr);
            Logger logger = mLogger;
            logger.info(str + "|" + format, new Object[0]);
        } catch (Exception e) {
            SystemUtils.log(3, "NavBaseLib || DLog", "Exception " + e.toString(), (Throwable) null, "com.didi.map.google.util.DLog", 20);
        }
    }
}
