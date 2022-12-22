package com.didi.beatles.p099im.utils;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.didi.beatles.im.utils.IMLog */
public final class IMLog {

    /* renamed from: a */
    private static boolean f9774a = Log.isLoggable("IMSecretLog", 3);

    /* renamed from: a */
    private static String m6628a(Throwable th, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder(th != null ? 512 : 128);
        if (str != null) {
            if (!(objArr == null || objArr.length == 0)) {
                str = objArr[0] + "";
            }
            sb.append(str);
        }
        sb.append(" ");
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
        sb.append(stackTraceElement.getMethodName());
        sb.append("():");
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")");
        if (th != null) {
            sb.append(10);
            sb.append(Log.getStackTraceString(th));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m6629a(int i, Throwable th, String str, Object... objArr) {
        if (f9774a) {
            String a = m6628a(th, str, objArr);
            if (i == 3) {
                SystemUtils.log(3, str, a, (Throwable) null, "com.didi.beatles.im.utils.IMLog", 61);
            } else if (i == 4) {
                SystemUtils.log(4, str, a, (Throwable) null, "com.didi.beatles.im.utils.IMLog", 64);
            } else if (i == 5) {
                SystemUtils.log(5, str, a, (Throwable) null, "com.didi.beatles.im.utils.IMLog", 67);
            } else if (i == 6) {
                SystemUtils.log(6, str, a, (Throwable) null, "com.didi.beatles.im.utils.IMLog", 70);
            }
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("msg=[");
            sb.append(str);
            String str2 = "";
            if (!(objArr == null || objArr.length == 0)) {
                str2 = objArr[0] + str2;
            }
            sb.append(str2);
            sb.append(Const.jaRight);
            String sb2 = sb.toString();
            Logger logger = LoggerFactory.getLogger((Class<?>) IMLog.class);
            if (i == 3 || i == 4) {
                logger.info(sb2, new Object[0]);
            } else if (i == 5) {
                logger.warn(sb2, new Object[0]);
            } else if (i != 6) {
                try {
                    logger.debug(sb2, new Object[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                logger.error(sb2, new Object[0]);
            }
        }
    }

    /* renamed from: v */
    public static void m6636v(String str, Object... objArr) {
        m6629a(2, (Throwable) null, str, objArr);
    }

    /* renamed from: d */
    public static void m6631d(String str, String str2) {
        m6629a(3, (Throwable) null, str, str2);
    }

    /* renamed from: d */
    public static void m6630d(String str) {
        m6629a(3, (Throwable) null, "im-sdk", str);
    }

    /* renamed from: i */
    public static void m6635i(String str, Object... objArr) {
        m6629a(4, (Throwable) null, str, objArr);
    }

    /* renamed from: w */
    public static void m6637w(String str, Object... objArr) {
        m6629a(5, (Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public static void m6633e(Throwable th) {
        m6629a(6, th, (String) null, new Object[0]);
    }

    /* renamed from: e */
    public static void m6632e(String str, Object... objArr) {
        m6629a(6, (Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public static void m6634e(Throwable th, String str, Object... objArr) {
        m6629a(6, th, str, objArr);
    }
}
