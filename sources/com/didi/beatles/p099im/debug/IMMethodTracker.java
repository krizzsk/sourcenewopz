package com.didi.beatles.p099im.debug;

/* renamed from: com.didi.beatles.im.debug.IMMethodTracker */
public class IMMethodTracker {

    /* renamed from: a */
    private static final boolean f9209a = false;

    /* renamed from: b */
    private static final String f9210b = "ImMethod";

    /* renamed from: d */
    private static IMMethodTracker f9211d;

    /* renamed from: c */
    private String f9212c;

    public void track() {
    }

    public void track(String str) {
    }

    public void track(Object... objArr) {
    }

    private IMMethodTracker(String str) {
        this.f9212c = str;
    }

    public static IMMethodTracker newInstance(String str) {
        if (f9211d == null) {
            f9211d = new IMMethodTracker(str);
        }
        return f9211d;
    }

    /* renamed from: a */
    private static String m6220a() {
        return new Exception().getStackTrace()[2].getMethodName();
    }
}
