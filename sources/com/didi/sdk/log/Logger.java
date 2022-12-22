package com.didi.sdk.log;

import android.content.Context;

public final class Logger {
    public static final String DEFAULT_TAG = "theone";
    public static final boolean IS_DEBUG = false;

    /* renamed from: a */
    private static final Printer f36441a = new C12380a();

    public static void clear(Context context) {
    }

    public static void initFloatView(Context context) {
    }

    public static void mToFv(String str) {
    }

    public static void removeFloatView(Context context) {
    }

    private Logger() {
    }

    public static Settings init() {
        return f36441a.init(DEFAULT_TAG);
    }

    public static Settings init(String str) {
        return f36441a.init(str);
    }

    /* renamed from: t */
    public static Printer m25813t(String str) {
        Printer printer = f36441a;
        return printer.mo92485t(str, printer.getSettings().getMethodCount());
    }

    /* renamed from: t */
    public static Printer m25812t(int i) {
        return f36441a.mo92485t((String) null, i);
    }

    /* renamed from: t */
    public static Printer m25814t(String str, int i) {
        return f36441a.mo92485t(str, i);
    }

    /* renamed from: d */
    public static void m25808d(String str, Object... objArr) {
        f36441a.mo92477d(str, objArr);
    }

    /* renamed from: e */
    public static void m25809e(String str, Object... objArr) {
        f36441a.mo92479e((Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public static void m25810e(Throwable th, String str, Object... objArr) {
        f36441a.mo92479e(th, str, objArr);
    }

    /* renamed from: i */
    public static void m25811i(String str, Object... objArr) {
        f36441a.mo92481i(str, objArr);
    }

    /* renamed from: v */
    public static void m25815v(String str, Object... objArr) {
        f36441a.mo92486v(str, objArr);
    }

    /* renamed from: w */
    public static void m25816w(String str, Object... objArr) {
        f36441a.mo92487w(str, objArr);
    }

    public static void wtf(String str, Object... objArr) {
        f36441a.wtf(str, objArr);
    }

    public static void easylog(String str, String str2) {
        m25813t(str).normalLog(str2);
    }

    public static void json(String str) {
        f36441a.json(str);
    }

    public static void xml(String str) {
        f36441a.xml(str);
    }

    public static Settings getSettings() {
        return f36441a.getSettings();
    }
}
