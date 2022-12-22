package com.airbnb.lottie.utils;

import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.LottieLogger;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger implements LottieLogger {

    /* renamed from: a */
    private static final Set<String> f1682a = new HashSet();

    public void debug(String str) {
        debug(str, (Throwable) null);
    }

    public void debug(String str, Throwable th) {
        if (C1429L.DBG) {
            SystemUtils.log(3, C1429L.TAG, str, th, "com.airbnb.lottie.utils.LogcatLogger", 29);
        }
    }

    public void warning(String str) {
        warning(str, (Throwable) null);
    }

    public void warning(String str, Throwable th) {
        if (!f1682a.contains(str)) {
            SystemUtils.log(5, C1429L.TAG, str, th, "com.airbnb.lottie.utils.LogcatLogger", 42);
            f1682a.add(str);
        }
    }

    public void error(String str, Throwable th) {
        if (C1429L.DBG) {
            SystemUtils.log(3, C1429L.TAG, str, th, "com.airbnb.lottie.utils.LogcatLogger", 49);
        }
    }
}
