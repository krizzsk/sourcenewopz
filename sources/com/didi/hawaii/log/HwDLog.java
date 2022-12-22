package com.didi.hawaii.log;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class HwDLog {
    private static final Logger mLogger = LoggerFactory.getLogger("map_group", "map");

    /* renamed from: d */
    public static void m16764d(String str, String str2, Object... objArr) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("|");
            sb.append(str2);
            for (Object append : objArr) {
                sb.append(",");
                sb.append(append);
            }
            mLogger.info(sb.toString(), new Object[0]);
        } catch (Exception e) {
            SystemUtils.log(3, "NavBaseLib || DLog", "Exception " + e.toString(), (Throwable) null, "com.didi.hawaii.log.HwDLog", 27);
        }
    }
}
