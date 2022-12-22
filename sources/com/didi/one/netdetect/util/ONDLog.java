package com.didi.one.netdetect.util;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;

public final class ONDLog {

    /* renamed from: a */
    private static int f29486a = 2;

    /* renamed from: a */
    private static boolean m20754a() {
        return false;
    }

    private ONDLog() {
        throw new RuntimeException();
    }

    /* renamed from: v */
    public static int m20761v(String str, String str2) {
        if (f29486a > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 27);
    }

    /* renamed from: v */
    public static int m20762v(String str, String str2, Throwable th) {
        if (f29486a > 2) {
            return 0;
        }
        return SystemUtils.log(2, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 39);
    }

    /* renamed from: d */
    public static int m20755d(String str, String str2) {
        if (f29486a > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 50);
    }

    /* renamed from: d */
    public static int m20756d(String str, String str2, Throwable th) {
        if (f29486a > 3) {
            return 0;
        }
        return SystemUtils.log(3, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 62);
    }

    /* renamed from: i */
    public static int m20759i(String str, String str2) {
        if (f29486a > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 73);
    }

    /* renamed from: i */
    public static int m20760i(String str, String str2, Throwable th) {
        if (f29486a > 4) {
            return 0;
        }
        return SystemUtils.log(4, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 85);
    }

    /* renamed from: w */
    public static int m20763w(String str, String str2) {
        if (f29486a > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 96);
    }

    /* renamed from: w */
    public static int m20764w(String str, String str2, Throwable th) {
        if (f29486a > 5) {
            return 0;
        }
        return SystemUtils.log(5, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 108);
    }

    /* renamed from: w */
    public static int m20765w(String str, Throwable th) {
        if (f29486a > 5) {
            return 0;
        }
        return Log.w(str, th);
    }

    /* renamed from: e */
    public static int m20757e(String str, String str2) {
        if (f29486a > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.one.netdetect.util.ONDLog", 130);
    }

    /* renamed from: e */
    public static int m20758e(String str, String str2, Throwable th) {
        if (f29486a > 6) {
            return 0;
        }
        return SystemUtils.log(6, str, str2, th, "com.didi.one.netdetect.util.ONDLog", 142);
    }

    public static void logClassAndMethod(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.hashCode());
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        if (!(stackTrace == null || stackTrace.length < 2 || stackTrace[1] == null)) {
            sb.append("|");
            sb.append(stackTrace[1].getMethodName());
        }
        m20755d(obj.getClass().getSimpleName(), sb.toString());
    }

    public static void setLevel(int i) {
        if (m20754a()) {
            f29486a = 2;
        } else {
            f29486a = i;
        }
    }
}
