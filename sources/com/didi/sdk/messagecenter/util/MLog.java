package com.didi.sdk.messagecenter.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class MLog {

    /* renamed from: a */
    private static Logger f36794a = LoggerFactory.getLogger("MessageCenter");

    /* renamed from: d */
    public static void m26058d(String str) {
        f36794a.debug(str, new Object[0]);
    }

    /* renamed from: i */
    public static void m26060i(String str) {
        f36794a.info(str, new Object[0]);
    }

    /* renamed from: w */
    public static void m26061w(String str) {
        f36794a.warn(str, new Object[0]);
    }

    /* renamed from: e */
    public static void m26059e(String str) {
        f36794a.error(str, new Object[0]);
    }
}
