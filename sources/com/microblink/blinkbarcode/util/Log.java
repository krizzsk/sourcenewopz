package com.microblink.blinkbarcode.util;

/* compiled from: line */
public class Log {
    private static LogWriter IlIllIlIIl = null;
    private static int llIIlIlIIl = 1;

    /* compiled from: line */
    public enum LogLevel {
        LOG_QUIET,
        LOG_WARNINGS_AND_ERRORS,
        LOG_INFORMATION,
        LOG_DEBUG,
        LOG_VERBOSE
    }

    /* compiled from: line */
    public interface LogWriter {
        void writeLog(String str, String str2, String str3, Throwable th);
    }

    static {
        LogLevel logLevel = LogLevel.LOG_WARNINGS_AND_ERRORS;
    }

    /* renamed from: d */
    public static void m40227d(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= 3) {
            llIIlIlIIl("[D]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), (Throwable) null);
        }
    }

    /* renamed from: e */
    public static void m40229e(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= 1) {
            llIIlIlIIl("[E]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), (Throwable) null);
        }
    }

    public static LogLevel getCurrentLogLevel() {
        return LogLevel.values()[llIIlIlIIl];
    }

    public static int getLineNumber() {
        if (Thread.currentThread().getStackTrace().length > 5) {
            return Thread.currentThread().getStackTrace()[5].getLineNumber();
        }
        return -1;
    }

    public static LogWriter getLogWriter() {
        return IlIllIlIIl;
    }

    public static String getThreadName() {
        return "@" + Thread.currentThread().getName();
    }

    /* renamed from: i */
    public static void m40231i(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= 2) {
            llIIlIlIIl("[I]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), (Throwable) null);
        }
    }

    private static String llIIlIlIIl(String str, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("(?<!\\\\)\\{\\}", -1);
        int i = 0;
        int i2 = 0;
        while (i < split.length) {
            int i3 = i + 1;
            sb.append(split[i]);
            if (i3 < split.length) {
                if (i2 < objArr.length) {
                    sb.append(objArr[i2]);
                    i2++;
                } else {
                    throw new RuntimeException("missing parameter for log message '" + str + "'");
                }
            }
            i = i3;
        }
        return sb.toString();
    }

    public static void setLogLevel(LogLevel logLevel) {
        llIIlIlIIl = logLevel.ordinal();
    }

    public static void setLogWriter(LogWriter logWriter) {
        IlIllIlIIl = logWriter;
    }

    /* renamed from: v */
    public static void m40233v(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= 4) {
            llIIlIlIIl("[V]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), (Throwable) null);
        }
    }

    /* renamed from: w */
    public static void m40235w(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= 1) {
            llIIlIlIIl("[W]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), (Throwable) null);
        }
    }

    public static void wtf(Object obj, String str, Object... objArr) {
        if (llIIlIlIIl >= 1) {
            String llIIlIlIIl2 = llIIlIlIIl(obj);
            String llIIlIlIIl3 = llIIlIlIIl(str, objArr);
            android.util.Log.wtf(llIIlIlIIl2, llIIlIlIIl3);
            llIIlIlIIl("[WTF]", llIIlIlIIl2, llIIlIlIIl3, (Throwable) null);
        }
    }

    /* renamed from: d */
    public static void m40228d(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= 3) {
            llIIlIlIIl("[D]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m40230e(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= 1) {
            llIIlIlIIl("[E]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m40232i(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= 2) {
            llIIlIlIIl("[I]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m40234v(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= 4) {
            llIIlIlIIl("[V]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m40236w(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= 1) {
            llIIlIlIIl("[W]", llIIlIlIIl(obj), llIIlIlIIl(str, objArr), th);
        }
    }

    public static void wtf(Object obj, Throwable th, String str, Object... objArr) {
        if (llIIlIlIIl >= 1) {
            String llIIlIlIIl2 = llIIlIlIIl(obj);
            String llIIlIlIIl3 = llIIlIlIIl(str, objArr);
            android.util.Log.wtf(llIIlIlIIl2, llIIlIlIIl3, th);
            llIIlIlIIl("[WTF]", llIIlIlIIl2, llIIlIlIIl3, th);
        }
    }

    private static String llIIlIlIIl(Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else if (obj instanceof String) {
            str = (String) obj;
        } else if (obj instanceof Class) {
            str = ((Class) obj).getSimpleName() + ".java";
        } else {
            str = obj.getClass().getSimpleName() + ".java";
        }
        return str + ":" + getLineNumber() + getThreadName();
    }

    private static void llIIlIlIIl(String str, String str2, String str3, Throwable th) {
        LogWriter logWriter = IlIllIlIIl;
        if (logWriter != null) {
            logWriter.writeLog(str, str2, str3, th);
        }
    }
}
