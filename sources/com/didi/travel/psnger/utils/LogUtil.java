package com.didi.travel.psnger.utils;

import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class LogUtil {

    /* renamed from: a */
    private static final boolean f44234a = true;

    /* renamed from: b */
    private static final String f44235b = "car_log_write_file";

    /* renamed from: c */
    private static final String f44236c = "isOutputLog";

    /* renamed from: d */
    private static final String f44237d = "isWriteFile";

    /* renamed from: e */
    private static String f44238e = "car_log";

    /* renamed from: f */
    private static boolean f44239f = false;

    /* renamed from: g */
    private static boolean f44240g = true;

    public static void setOutput(boolean z) {
        f44239f = z;
    }

    public static void setWriteFile(boolean z) {
        f44240g = z;
    }

    public static void setTag(String str) {
        f44238e = str;
    }

    /* renamed from: v */
    public static void m31436v(String str) {
        m31424a(2, str);
    }

    /* renamed from: v */
    public static void m31437v(String str, String str2) {
        m31425a(2, str, str2);
    }

    /* renamed from: d */
    public static void m31426d(String str) {
        m31424a(3, str);
    }

    /* renamed from: d */
    public static void m31427d(String str, String str2) {
        m31425a(3, str, str2);
    }

    /* renamed from: i */
    public static void m31434i(String str) {
        m31424a(4, str);
    }

    /* renamed from: i */
    public static void m31435i(String str, String str2) {
        m31425a(4, str, str2);
    }

    /* renamed from: w */
    public static void m31438w(String str) {
        m31424a(5, str);
    }

    /* renamed from: w */
    public static void m31439w(String str, String str2) {
        m31425a(5, str, str2);
    }

    /* renamed from: e */
    public static void m31429e(String str) {
        m31424a(6, str);
    }

    /* renamed from: e */
    public static void m31430e(String str, String str2) {
        m31425a(6, str, str2);
    }

    /* renamed from: d */
    public static void m31428d(String str, String str2, Throwable th) {
        m31425a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m31432fi(String str) {
        if (f44240g) {
            Logger logger = LoggerFactory.getLogger(f44238e);
            TagInfo a = m31423a(4);
            String access$000 = a.tagName;
            m31425a(4, access$000, str + a.jumpInfo);
            logger.info("%s %s %s", a.tagName, str, a.jumpInfo);
        }
    }

    /* renamed from: fw */
    public static void m31433fw(String str) {
        if (f44240g) {
            Logger logger = LoggerFactory.getLogger(f44238e);
            TagInfo a = m31423a(4);
            String access$000 = a.tagName;
            m31425a(5, access$000, str + a.jumpInfo);
            logger.warn("%s %s %s", a.tagName, str, a.jumpInfo);
        }
    }

    /* renamed from: fe */
    public static void m31431fe(String str) {
        if (f44240g) {
            Logger logger = LoggerFactory.getLogger(f44238e);
            TagInfo a = m31423a(4);
            String access$000 = a.tagName;
            m31425a(6, access$000, str + a.jumpInfo);
            logger.error("%s %s %s", a.tagName, str, a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m31424a(int i, String str) {
        if (f44239f) {
            TagInfo a = m31423a(5);
            String access$000 = a.tagName;
            m31425a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m31425a(int i, String str, String str2) {
        if (f44239f) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didi.travel.psnger.utils.LogUtil", 197);
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
    private static TagInfo m31423a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = f44238e;
        } else {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className)) {
                String unused2 = tagInfo.tagName = className.substring(className.lastIndexOf(".") + 1, className.length()) + "|" + stackTraceElement.getMethodName();
                String unused3 = tagInfo.jumpInfo = " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") ";
            }
        }
        return tagInfo;
    }

    public static void printStackTrace() {
        new Throwable("Don't panic, just print the stack trace.").printStackTrace();
    }
}
