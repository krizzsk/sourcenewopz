package com.didi.permission.core;

import android.util.Log;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class LogUtil {

    /* renamed from: a */
    private static final boolean f33032a = false;

    /* renamed from: b */
    private static String f33033b = "Permission_log";

    /* renamed from: c */
    private static boolean f33034c = false;

    /* renamed from: d */
    private static boolean f33035d = true;

    public static void setOutput(boolean z) {
        f33034c = z;
    }

    public static void setWriteFile(boolean z) {
        f33035d = z;
    }

    public static void setTag(String str) {
        f33033b = str;
    }

    /* renamed from: v */
    public static void m23229v(String str) {
        m23217a(2, str);
    }

    /* renamed from: v */
    public static void m23230v(String str, String str2) {
        m23218a(2, str, str2);
    }

    /* renamed from: d */
    public static void m23219d(String str) {
        m23217a(3, str);
    }

    /* renamed from: d */
    public static void m23220d(String str, String str2) {
        m23218a(3, str, str2);
    }

    /* renamed from: i */
    public static void m23227i(String str) {
        m23217a(4, str);
    }

    /* renamed from: i */
    public static void m23228i(String str, String str2) {
        m23218a(4, str, str2);
    }

    /* renamed from: w */
    public static void m23231w(String str) {
        m23217a(5, str);
    }

    /* renamed from: w */
    public static void m23232w(String str, String str2) {
        m23218a(5, str, str2);
    }

    /* renamed from: e */
    public static void m23222e(String str) {
        m23217a(6, str);
    }

    /* renamed from: e */
    public static void m23223e(String str, String str2) {
        m23218a(6, str, str2);
    }

    /* renamed from: d */
    public static void m23221d(String str, String str2, Throwable th) {
        m23218a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m23225fi(String str) {
        if (f33035d) {
            LoggerFactory.getLogger(f33033b).info(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fw */
    public static void m23226fw(String str) {
        if (f33035d) {
            Logger logger = LoggerFactory.getLogger(f33033b);
            m23218a(5, f33033b, str);
            logger.warn(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fe */
    public static void m23224fe(String str) {
        if (f33035d) {
            LoggerFactory.getLogger(f33033b).error(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: a */
    private static void m23217a(int i, String str) {
        if (f33034c) {
            m23218a(i, f33033b, str);
        }
    }

    /* renamed from: a */
    private static void m23218a(int i, String str, String str2) {
        if (f33034c) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.permission.core.LogUtil", 184);
        }
    }

    public static void printStackTrace() {
        if (f33034c) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }
}
