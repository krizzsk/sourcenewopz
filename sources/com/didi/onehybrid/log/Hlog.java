package com.didi.onehybrid.log;

import com.didi.sdk.apm.SystemUtils;

public class Hlog {

    /* renamed from: a */
    private static final String f29637a = "Hybrid-Tag";

    /* renamed from: b */
    private static final boolean f29638b = true;

    public static void DebugLog(String str) {
        SystemUtils.log(3, f29637a, str, (Throwable) null, "com.didi.onehybrid.log.Hlog", 15);
    }
}
