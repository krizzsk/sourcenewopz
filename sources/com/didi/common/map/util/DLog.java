package com.didi.common.map.util;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class DLog {
    private static final Logger mLogger = LoggerFactory.getLogger("map_group", "map");

    /* renamed from: d */
    public static void m7384d(String str, String str2, Object... objArr) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("|");
            sb.append(str2);
            if (objArr != null) {
                for (Object append : objArr) {
                    sb.append(",");
                    sb.append(append);
                }
            }
            mLogger.info(sb.toString(), new Object[0]);
        } catch (Exception e) {
            SystemUtils.log(3, "NavBaseLib || DLog", "Exception " + e.toString(), (Throwable) null, "com.didi.common.map.util.DLog", 29);
        }
    }
}
