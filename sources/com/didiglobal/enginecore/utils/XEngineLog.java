package com.didiglobal.enginecore.utils;

import android.util.Log;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;

public class XEngineLog {

    /* renamed from: a */
    private static String f50209a = "Bff";

    /* renamed from: b */
    private static boolean f50210b = false;

    /* renamed from: c */
    private static boolean f50211c = true;

    public static void setWriteFile(boolean z) {
        f50211c = z;
    }

    public static void setOutput(boolean z) {
        f50210b = z;
    }

    public static void setTag(String str) {
        f50209a = str;
    }

    /* renamed from: v */
    public static void m36190v(String str) {
        m36179a(2, str);
    }

    /* renamed from: v */
    public static void m36191v(String str, String str2) {
        m36180a(2, str, str2);
    }

    /* renamed from: d */
    public static void m36181d(String str) {
        m36179a(3, str);
    }

    /* renamed from: d */
    public static void m36182d(String str, String str2) {
        m36180a(3, str, str2);
    }

    /* renamed from: w */
    public static void m36192w(String str) {
        m36179a(5, str);
    }

    /* renamed from: w */
    public static void m36193w(String str, String str2) {
        m36180a(5, str, str2);
    }

    /* renamed from: e */
    public static void m36184e(String str) {
        m36179a(6, str);
    }

    /* renamed from: e */
    public static void m36185e(String str, String str2) {
        m36180a(6, str, str2);
    }

    /* renamed from: e */
    public static void m36186e(String str, String str2, Throwable th) {
        m36180a(6, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: d */
    public static void m36183d(String str, String str2, Throwable th) {
        m36180a(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m36188fi(String str) {
        if (f50211c) {
            Logger logger = LoggerFactory.getLogger(f50209a);
            if (f50210b) {
                TagInfo a = m36178a(4);
                logger.info("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.info(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fw */
    public static void m36189fw(String str) {
        if (f50211c) {
            Logger logger = LoggerFactory.getLogger(f50209a);
            if (f50210b) {
                TagInfo a = m36178a(4);
                logger.warn("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.warn(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fe */
    public static void m36187fe(String str) {
        if (f50211c) {
            Logger logger = LoggerFactory.getLogger(f50209a);
            if (f50210b) {
                TagInfo a = m36178a(4);
                logger.error("%s %s %s", a.tagName, str, a.jumpInfo);
                return;
            }
            logger.error(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    public static void printStackTrace() {
        if (f50210b) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m36179a(int i, String str) {
        if (f50210b) {
            TagInfo a = m36178a(5);
            String access$000 = a.tagName;
            m36180a(i, access$000, str + a.jumpInfo);
        }
    }

    /* renamed from: a */
    private static void m36180a(int i, String str, String str2) {
        if (f50210b) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.didiglobal.enginecore.utils.XEngineLog", 196);
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
    private static TagInfo m36178a(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = f50209a;
        } else {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            if (!TextUtil.isEmpty(className)) {
                String unused2 = tagInfo.tagName = className.substring(className.lastIndexOf(".") + 1, className.length()) + "|" + stackTraceElement.getMethodName();
                String unused3 = tagInfo.jumpInfo = " (" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") ";
            }
        }
        return tagInfo;
    }
}
