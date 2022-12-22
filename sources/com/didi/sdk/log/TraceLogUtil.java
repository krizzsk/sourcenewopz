package com.didi.sdk.log;

public class TraceLogUtil {
    public static void addLogWithTab(String str, String... strArr) {
        TraceLogListener logListener = TraceLogHolder.getInstance().getLogListener();
        if (logListener != null) {
            logListener.addLogWithTab(str, strArr);
        }
    }
}
