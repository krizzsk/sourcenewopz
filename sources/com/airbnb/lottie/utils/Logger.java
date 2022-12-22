package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

public class Logger {

    /* renamed from: a */
    private static LottieLogger f1683a = new LogcatLogger();

    public static void setInstance(LottieLogger lottieLogger) {
        f1683a = lottieLogger;
    }

    public static void debug(String str) {
        f1683a.debug(str);
    }

    public static void debug(String str, Throwable th) {
        f1683a.debug(str, th);
    }

    public static void warning(String str) {
        f1683a.warning(str);
    }

    public static void warning(String str, Throwable th) {
        f1683a.warning(str, th);
    }

    public static void error(String str, Throwable th) {
        f1683a.error(str, th);
    }
}
