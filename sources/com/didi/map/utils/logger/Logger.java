package com.didi.map.utils.logger;

public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a */
    private static Printer f29045a = new C10237a();

    public static boolean isLoggable() {
        return false;
    }

    private Logger() {
    }

    public static void printer(Printer printer) {
        f29045a = (Printer) C10238b.m20477b(printer);
    }

    public static void addLogAdapter(LogAdapter logAdapter) {
        f29045a.addAdapter((LogAdapter) C10238b.m20477b(logAdapter));
    }

    public static void clearLogAdapters() {
        f29045a.clearLogAdapters();
    }

    /* renamed from: t */
    public static Printer m20441t(String str) {
        return f29045a.mo79954t(str);
    }

    public static void log(int i, String str, String str2, Throwable th) {
        if (isLoggable()) {
            f29045a.log(i, str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m20437d(String str, Object... objArr) {
        if (isLoggable()) {
            f29045a.mo79948d(str, objArr);
        }
    }

    /* renamed from: d */
    public static void m20436d(Object obj) {
        if (isLoggable()) {
            f29045a.mo79947d(obj);
        }
    }

    /* renamed from: e */
    public static void m20438e(String str, Object... objArr) {
        if (isLoggable()) {
            f29045a.mo79950e((Throwable) null, str, objArr);
        }
    }

    /* renamed from: e */
    public static void m20439e(Throwable th, String str, Object... objArr) {
        if (isLoggable()) {
            f29045a.mo79950e(th, str, objArr);
        }
    }

    /* renamed from: i */
    public static void m20440i(String str, Object... objArr) {
        if (isLoggable()) {
            f29045a.mo79951i(str, objArr);
        }
    }

    /* renamed from: v */
    public static void m20442v(String str, Object... objArr) {
        if (isLoggable()) {
            f29045a.mo79955v(str, objArr);
        }
    }

    /* renamed from: w */
    public static void m20443w(String str, Object... objArr) {
        if (isLoggable()) {
            f29045a.mo79956w(str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        if (isLoggable()) {
            f29045a.wtf(str, objArr);
        }
    }

    public static void json(String str) {
        if (isLoggable()) {
            f29045a.json(str);
        }
    }

    public static void xml(String str) {
        if (isLoggable()) {
            f29045a.xml(str);
        }
    }
}
