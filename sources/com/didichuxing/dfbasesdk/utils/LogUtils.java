package com.didichuxing.dfbasesdk.utils;

import com.didi.sdk.apm.SystemUtils;
import rui.config.RConfigConstants;

public class LogUtils {

    /* renamed from: a */
    private static final String f46745a = "DiFace";

    private LogUtils() {
    }

    /* renamed from: a */
    private static String m33562a(String str, StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return str;
        }
        String a = m33561a(stackTraceElement.getClassName());
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        String fileName = stackTraceElement.getFileName();
        return str + " at " + a + RConfigConstants.KEYWORD_COLOR_SIGN + methodName + " (" + fileName + ":" + lineNumber + ")  ";
    }

    /* renamed from: a */
    private static String m33561a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: a */
    private static StackTraceElement m33560a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            boolean equals = stackTraceElement.getClassName().equals(LogUtils.class.getName());
            if (z && !equals) {
                return stackTraceElement;
            }
            i++;
            z = equals;
        }
        return null;
    }

    /* renamed from: d */
    public static void m33564d(String str, String str2) {
        if (DebugUtils.isDebug()) {
            SystemUtils.log(3, str, m33562a(str2, m33560a()), (Throwable) null, "com.didichuxing.dfbasesdk.utils.LogUtils", 45);
        }
    }

    /* renamed from: d */
    public static void m33563d(String str) {
        m33564d(f46745a, str);
    }

    /* renamed from: i */
    public static void m33570i(String str, String str2) {
        SystemUtils.log(4, str, str2, (Throwable) null, "com.didichuxing.dfbasesdk.utils.LogUtils", 54);
    }

    /* renamed from: i */
    public static void m33569i(String str) {
        m33570i(f46745a, str);
    }

    /* renamed from: e */
    public static void m33566e(String str, String str2) {
        SystemUtils.log(6, str, str2, (Throwable) null, "com.didichuxing.dfbasesdk.utils.LogUtils", 62);
    }

    /* renamed from: e */
    public static void m33567e(String str, String str2, Throwable th) {
        SystemUtils.log(6, str, str2, th, "com.didichuxing.dfbasesdk.utils.LogUtils", 66);
    }

    /* renamed from: e */
    public static void m33565e(String str) {
        m33566e(f46745a, str);
    }

    /* renamed from: e */
    public static void m33568e(String str, Throwable th) {
        m33567e(f46745a, str, th);
    }

    public static void logStackTrace(Throwable th) {
        if (DebugUtils.isDebug() && th != null) {
            th.printStackTrace();
        }
    }
}
