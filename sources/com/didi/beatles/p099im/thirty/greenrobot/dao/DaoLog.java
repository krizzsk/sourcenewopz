package com.didi.beatles.p099im.thirty.greenrobot.dao;

import android.util.Log;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.DaoLog */
public class DaoLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a */
    private static final String f9659a = "greenDAO";

    public static boolean isLoggable(int i) {
        return Log.isLoggable(f9659a, i);
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void println(int i, String str) {
        SystemUtils.log(i, f9659a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 47);
    }

    /* renamed from: v */
    public static void m6530v(String str) {
        SystemUtils.log(2, f9659a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 51);
    }

    /* renamed from: v */
    public static void m6531v(String str, Throwable th) {
        SystemUtils.log(2, f9659a, str, th, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 55);
    }

    /* renamed from: d */
    public static void m6524d(String str) {
        IMLog.m6631d(f9659a, str);
    }

    /* renamed from: d */
    public static void m6525d(String str, Throwable th) {
        IMLog.m6631d(f9659a, str);
    }

    /* renamed from: i */
    public static void m6528i(String str) {
        SystemUtils.log(4, f9659a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 67);
    }

    /* renamed from: i */
    public static void m6529i(String str, Throwable th) {
        SystemUtils.log(4, f9659a, str, th, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 71);
    }

    /* renamed from: w */
    public static void m6532w(String str) {
        SystemUtils.log(5, f9659a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 75);
    }

    /* renamed from: w */
    public static void m6533w(String str, Throwable th) {
        SystemUtils.log(5, f9659a, str, th, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 79);
    }

    /* renamed from: w */
    public static void m6534w(Throwable th) {
        Log.w(f9659a, th);
    }

    /* renamed from: e */
    public static void m6526e(String str) {
        SystemUtils.log(5, f9659a, str, (Throwable) null, "com.didi.beatles.im.thirty.greenrobot.dao.DaoLog", 87);
    }

    /* renamed from: e */
    public static void m6527e(String str, Throwable th) {
        IMLog.m6632e(f9659a, str, th);
    }
}
