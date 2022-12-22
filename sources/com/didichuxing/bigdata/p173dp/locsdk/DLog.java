package com.didichuxing.bigdata.p173dp.locsdk;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DLog */
public class DLog {
    private static final Logger mLogger = LoggerFactory.getLogger("didi-locsdk", "locsdk");

    /* renamed from: d */
    public static void m32737d(String str) {
        try {
            mLogger.info(str, new Object[0]);
        } catch (Exception e) {
            SystemUtils.log(3, "DLog", "Exception " + e.toString(), (Throwable) null, "com.didichuxing.bigdata.dp.locsdk.DLog", 19);
        }
    }
}
