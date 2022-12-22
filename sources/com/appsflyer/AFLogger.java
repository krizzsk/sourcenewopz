package com.appsflyer;

import androidx.exifinterface.media.ExifInterface;
import com.appsflyer.internal.C1683ai;
import com.didi.sdk.apm.SystemUtils;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AFLogger {

    /* renamed from: ι */
    private static long f1763 = System.currentTimeMillis();

    public static void afInfoLog(String str, boolean z) {
        if (m1515(LogLevel.INFO)) {
            SystemUtils.log(4, AppsFlyerLibCore.LOG_TAG, m1510(str, false), (Throwable) null, "com.appsflyer.AFLogger", 22);
        }
        if (z) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai.f1911.mo16117((String) null, "I", m1510(str, true));
        }
    }

    public static void resetDeltaTime() {
        f1763 = System.currentTimeMillis();
    }

    /* renamed from: ǃ */
    private static String m1510(String str, boolean z) {
        if (!z && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(m1513(System.currentTimeMillis() - f1763));
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: ı */
    private static void m1509(String str, Throwable th, boolean z) {
        String[] strArr;
        if (m1515(LogLevel.ERROR) && z) {
            SystemUtils.log(6, AppsFlyerLibCore.LOG_TAG, m1510(str, false), th, "com.appsflyer.AFLogger", 60);
        }
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai aiVar = C1683ai.f1911;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        StackTraceElement[] stackTrace = cause == null ? th.getStackTrace() : cause.getStackTrace();
        if (stackTrace == null) {
            strArr = new String[]{message};
        } else {
            String[] strArr2 = new String[(stackTrace.length + 1)];
            strArr2[0] = message;
            for (int i = 1; i < stackTrace.length; i++) {
                strArr2[i] = stackTrace[i].toString();
            }
            strArr = strArr2;
        }
        aiVar.mo16117("exception", simpleName, strArr);
    }

    /* renamed from: Ι */
    static void m1514(String str) {
        if (m1515(LogLevel.WARNING)) {
            SystemUtils.log(5, AppsFlyerLibCore.LOG_TAG, m1510(str, false), (Throwable) null, "com.appsflyer.AFLogger", 69);
        }
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117((String) null, ExifInterface.LONGITUDE_WEST, m1510(str, true));
    }

    public static void afRDLog(String str) {
        if (m1515(LogLevel.VERBOSE)) {
            SystemUtils.log(2, AppsFlyerLibCore.LOG_TAG, m1510(str, false), (Throwable) null, "com.appsflyer.AFLogger", 78);
        }
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117((String) null, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, m1510(str, true));
    }

    /* renamed from: Ι */
    private static boolean m1515(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    /* renamed from: ǃ */
    static void m1511(String str) {
        if (!m1512()) {
            SystemUtils.log(3, AppsFlyerLibCore.LOG_TAG, m1510(str, false), (Throwable) null, "com.appsflyer.AFLogger", 90);
        }
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117((String) null, "F", str);
    }

    /* renamed from: ɩ */
    private static boolean m1512() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        m1509(str, th, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        m1509(str, th, z);
    }

    public static void afWarnLog(String str) {
        m1514(str);
    }

    /* renamed from: Ι */
    private static String m1513(long j) {
        long hours = TimeUnit.MILLISECONDS.toHours(j);
        long millis = j - TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long millis2 = millis - TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis2);
        long millis3 = TimeUnit.MILLISECONDS.toMillis(millis2 - TimeUnit.SECONDS.toMillis(seconds));
        return String.format(Locale.getDefault(), "%02d:%02d:%02d:%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(millis3)});
    }

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        

        /* renamed from: ɩ */
        private int f1765;

        private LogLevel(int i) {
            this.f1765 = i;
        }

        public final int getLevel() {
            return this.f1765;
        }
    }

    public static void afDebugLog(String str) {
        if (m1515(LogLevel.DEBUG)) {
            SystemUtils.log(3, AppsFlyerLibCore.LOG_TAG, m1510(str, false), (Throwable) null, "com.appsflyer.AFLogger", 8051);
        }
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117((String) null, "D", m1510(str, true));
    }
}
