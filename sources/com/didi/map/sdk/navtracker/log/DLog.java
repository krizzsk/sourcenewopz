package com.didi.map.sdk.navtracker.log;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class DLog {

    /* renamed from: a */
    private static final Logger f28574a = LoggerFactory.getLogger("map_group", "map");

    /* renamed from: d */
    public static void m20199d(String str, String str2, Object... objArr) {
        String format = String.format(str2, objArr);
        Logger logger = f28574a;
        logger.info(str + "|" + format, new Object[0]);
    }
}
