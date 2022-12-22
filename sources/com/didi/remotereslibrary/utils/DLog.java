package com.didi.remotereslibrary.utils;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class DLog {

    /* renamed from: a */
    private static final String f33183a = "remoteresource";

    /* renamed from: b */
    private static final Logger f33184b = LoggerFactory.getLogger(f33183a);

    /* renamed from: e */
    public static void m23372e(String str, String str2, int i) {
        f33184b.error("[%s]---> %s", str, str2);
    }

    /* renamed from: d */
    public static void m23371d(String str, String str2) {
        f33184b.debug("[%s]---> %s", str, str2);
    }

    /* renamed from: w */
    public static void m23374w(String str, String str2) {
        f33184b.warn("[%s]---> %s", str, str2);
    }

    /* renamed from: i */
    public static void m23373i(String str, String str2) {
        f33184b.info("[%s]---> %s", str, str2);
    }
}
