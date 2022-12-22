package com.facebook.common.logging;

import java.util.Locale;

public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            sHandler = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* renamed from: v */
    public static void m37126v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m37127v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(str, formatString(str2, obj));
        }
    }

    /* renamed from: v */
    public static void m37128v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m37129v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m37130v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m37118v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(getTag(cls), str);
        }
    }

    /* renamed from: v */
    public static void m37119v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: v */
    public static void m37120v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m37121v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m37118v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m37122v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m37132v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(str, formatString(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m37133v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127782v(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m37124v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127781v(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: v */
    public static void m37125v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127782v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m37131v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127782v(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m37123v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo127782v(getTag(cls), str, th);
        }
    }

    /* renamed from: d */
    public static void m37086d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m37087d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(str, formatString(str2, obj));
        }
    }

    /* renamed from: d */
    public static void m37088d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m37089d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m37090d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m37078d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(getTag(cls), str);
        }
    }

    /* renamed from: d */
    public static void m37079d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: d */
    public static void m37080d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m37081d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m37082d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m37092d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m37086d(str, formatString(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m37093d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m37091d(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m37084d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127770d(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m37085d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127771d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m37091d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127771d(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m37083d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo127771d(getTag(cls), str, th);
        }
    }

    /* renamed from: i */
    public static void m37110i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m37111i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(str, formatString(str2, obj));
        }
    }

    /* renamed from: i */
    public static void m37112i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m37113i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m37114i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m37102i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(getTag(cls), str);
        }
    }

    /* renamed from: i */
    public static void m37103i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: i */
    public static void m37104i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m37105i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m37106i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m37116i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(str, formatString(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m37117i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127776i(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m37108i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127775i(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: i */
    public static void m37109i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo127776i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m37115i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127776i(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m37107i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo127776i(getTag(cls), str, th);
        }
    }

    /* renamed from: w */
    public static void m37138w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo127783w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m37134w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo127783w(getTag(cls), str);
        }
    }

    /* renamed from: w */
    public static void m37140w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo127783w(str, formatString(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m37141w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo127784w(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m37136w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo127783w(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: w */
    public static void m37137w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m37135w(cls, formatString(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m37139w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo127784w(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m37135w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo127784w(getTag(cls), str, th);
        }
    }

    /* renamed from: e */
    public static void m37098e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127772e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m37094e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127772e(getTag(cls), str);
        }
    }

    /* renamed from: e */
    public static void m37100e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127772e(str, formatString(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m37101e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127773e(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m37096e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127772e(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m37097e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127773e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m37099e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127773e(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m37095e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo127773e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format((Locale) null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
