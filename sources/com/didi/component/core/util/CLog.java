package com.didi.component.core.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class CLog {

    /* renamed from: a */
    private static Logger f12759a = LoggerFactory.getLogger("Component");

    /* renamed from: d */
    public static void m8708d(String str) {
        f12759a.debug(str, new Object[0]);
    }

    /* renamed from: i */
    public static void m8710i(String str) {
        f12759a.info(str, new Object[0]);
    }

    /* renamed from: w */
    public static void m8711w(String str) {
        f12759a.warn(str, new Object[0]);
    }

    /* renamed from: e */
    public static void m8709e(String str) {
        f12759a.error(str, new Object[0]);
    }
}
