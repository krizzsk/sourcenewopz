package com.didichuxing.apollo.sdk.log;

import com.didi.sdk.apm.SystemUtils;

public class LogUtils {
    public static boolean DEBUG = false;

    /* renamed from: a */
    private static final String f45627a = "apollo";

    /* renamed from: b */
    private static ILogDelegate f45628b;

    public static void attachLogDelegate(ILogDelegate iLogDelegate) {
        f45628b = iLogDelegate;
    }

    public static void detachLogDelegate() {
        f45628b = null;
    }

    /* renamed from: d */
    public static void m32691d(String str, String str2) {
        if (DEBUG) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didichuxing.apollo.sdk.log.LogUtils", 23);
        }
    }

    /* renamed from: d */
    public static void m32690d(String str) {
        if (DEBUG) {
            m32691d("apollo", str);
        }
    }

    /* renamed from: e */
    public static void m32692e(String str) {
        ILogDelegate iLogDelegate = f45628b;
        if (iLogDelegate != null) {
            iLogDelegate.saveErrorLog(new ApolloErrorLog(str));
        }
    }
}
