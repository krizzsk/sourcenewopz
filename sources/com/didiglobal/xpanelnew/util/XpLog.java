package com.didiglobal.xpanelnew.util;

import android.text.TextUtils;
import android.util.Log;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class XpLog {

    /* renamed from: a */
    private static boolean f51627a = false;

    /* renamed from: b */
    private static boolean f51628b = true;
    public static String sTAG = "NewXpanelLog";

    public static void setWriteFile(boolean z) {
        f51628b = z;
    }

    public static void setOutput(boolean z) {
        f51627a = z;
    }

    public static void setTag(String str) {
        sTAG = str;
    }

    /* renamed from: v */
    public static void m36932v(String str) {
        m36921a(2, str);
    }

    /* renamed from: v */
    public static void m36933v(String str, String str2) {
        m36922a(2, str, str2);
    }

    /* renamed from: d */
    public static void m36923d(String str) {
        m36921a(3, str);
    }

    /* renamed from: d */
    public static void m36924d(String str, String str2) {
        m36922a(3, str, str2);
    }

    /* renamed from: w */
    public static void m36934w(String str) {
        m36921a(5, str);
    }

    /* renamed from: w */
    public static void m36935w(String str, String str2) {
        m36922a(5, str, str2);
    }

    /* renamed from: e */
    public static void m36926e(String str) {
        m36921a(6, str);
    }

    /* renamed from: e */
    public static void m36927e(String str, String str2) {
        m36922a(6, str, str2);
    }

    /* renamed from: e */
    public static void m36928e(String str, String str2, Throwable th) {
        m36922a(6, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: d */
    public static void m36925d(String str, String str2, Throwable th) {
        m36922a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m36930fi(String str) {
        if (f51628b) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (f51627a) {
                TagInfo a = m36920a(4);
                logger.info("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.info(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fw */
    public static void m36931fw(String str) {
        if (f51628b) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (f51627a) {
                TagInfo a = m36920a(4);
                logger.warn("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.warn(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fe */
    public static void m36929fe(String str) {
        if (f51628b) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (f51627a) {
                TagInfo a = m36920a(4);
                logger.error("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.error(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    public static void printStackTrace() {
        if (f51627a) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m36921a(int i, String str) {
        if (f51627a) {
            TagInfo a = m36920a(5);
            String access$000 = a.tagName;
            m36922a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m36922a(int i, String str, String str2) {
        if (f51627a) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didiglobal.xpanelnew.util.XpLog", 201);
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
    private static TagInfo m36920a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = sTAG;
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
}
