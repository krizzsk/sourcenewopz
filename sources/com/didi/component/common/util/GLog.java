package com.didi.component.common.util;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;

public class GLog {

    /* renamed from: a */
    private static String f11756a = "g_log";

    /* renamed from: b */
    private static boolean f11757b = false;

    public static void setOutput(boolean z) {
        f11757b = z;
    }

    public static void setTag(String str) {
        f11756a = str;
    }

    /* renamed from: v */
    public static void m7972v(String str, String str2) {
        m7963a(2, str, str2);
    }

    /* renamed from: d */
    public static void m7964d(String str) {
        m7962a(3, str);
    }

    /* renamed from: d */
    public static void m7965d(String str, String str2) {
        m7963a(3, str, str2);
    }

    /* renamed from: i */
    public static void m7970i(String str) {
        m7962a(4, str);
    }

    /* renamed from: i */
    public static void m7971i(String str, String str2) {
        m7963a(4, str, str2);
    }

    /* renamed from: w */
    public static void m7973w(String str) {
        m7962a(5, str);
    }

    /* renamed from: w */
    public static void m7974w(String str, String str2) {
        m7963a(5, str, str2);
    }

    /* renamed from: e */
    public static void m7967e(String str) {
        m7962a(6, str);
    }

    /* renamed from: e */
    public static void m7968e(String str, String str2) {
        m7963a(6, str, str2);
    }

    /* renamed from: e */
    public static void m7969e(String str, String str2, Throwable th) {
        m7963a(6, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: d */
    public static void m7966d(String str, String str2, Throwable th) {
        m7963a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    public static void printStackTrace() {
        if (f11757b) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m7962a(int i, String str) {
        if (f11757b) {
            TagInfo a = m7961a(5);
            String access$000 = a.tagName;
            m7963a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m7963a(int i, String str, String str2) {
        if (f11757b) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.component.common.util.GLog", 141);
        }
    }

    private static class TagInfo {
        /* access modifiers changed from: private */
        public String jumpInfo;
        /* access modifiers changed from: private */
        public String tagName;

        private TagInfo() {
            this.tagName = "";
            this.jumpInfo = "";
        }
    }

    /* renamed from: a */
    private static TagInfo m7961a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = f11756a;
        } else {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            if (!TextUtil.isEmpty(className)) {
                String unused2 = tagInfo.tagName = className.substring(className.lastIndexOf(".") + 1, className.length());
                String unused3 = tagInfo.jumpInfo = " (" + stackTraceElement.getFileName() + "-" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + ") ";
            }
        }
        return tagInfo;
    }
}
