package com.android.didi.bfflib.utils;

import android.util.Log;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;

public class BffLog {
    private static boolean sOutput = false;
    private static String sTAG = "GlobalBff";
    private static boolean sWriteFile = true;

    public static void setWriteFile(boolean z) {
        sWriteFile = z;
    }

    public static void setOutput(boolean z) {
        sOutput = z;
    }

    public static void setTag(String str) {
        sTAG = str;
    }

    /* renamed from: v */
    public static void m1489v(String str) {
        log(2, str);
    }

    /* renamed from: v */
    public static void m1490v(String str, String str2) {
        log(2, str, str2);
    }

    /* renamed from: d */
    public static void m1480d(String str) {
        log(3, str);
    }

    /* renamed from: d */
    public static void m1481d(String str, String str2) {
        log(3, str, str2);
    }

    /* renamed from: w */
    public static void m1491w(String str) {
        log(5, str);
    }

    /* renamed from: w */
    public static void m1492w(String str, String str2) {
        log(5, str, str2);
    }

    /* renamed from: e */
    public static void m1483e(String str) {
        log(6, str);
    }

    /* renamed from: e */
    public static void m1484e(String str, String str2) {
        log(6, str, str2);
    }

    /* renamed from: e */
    public static void m1485e(String str, String str2, Throwable th) {
        log(6, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: d */
    public static void m1482d(String str, String str2, Throwable th) {
        log(3, str, str2 + 10 + Log.getStackTraceString(th));
    }

    /* renamed from: fi */
    public static void m1487fi(String str) {
        if (sWriteFile) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (sOutput) {
                TagInfo createTagInfo = createTagInfo(4);
                logger.info("%s %s %s", createTagInfo.tagName, str, createTagInfo.jumpInfo);
                return;
            }
            logger.info(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fw */
    public static void m1488fw(String str) {
        if (sWriteFile) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (sOutput) {
                TagInfo createTagInfo = createTagInfo(4);
                logger.warn("%s %s %s", createTagInfo.tagName, str, createTagInfo.jumpInfo);
                return;
            }
            logger.warn(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    /* renamed from: fe */
    public static void m1486fe(String str) {
        if (sWriteFile) {
            Logger logger = LoggerFactory.getLogger(sTAG);
            if (sOutput) {
                TagInfo createTagInfo = createTagInfo(4);
                logger.error("%s %s %s", createTagInfo.tagName, str, createTagInfo.jumpInfo);
                return;
            }
            logger.error(InvitationTrackFragment.INVITE_DATE, str);
        }
    }

    public static void printStackTrace() {
        if (sOutput) {
            new Throwable("Don't panic, just print the stack trace.").printStackTrace();
        }
    }

    private static void log(int i, String str) {
        if (sOutput) {
            TagInfo createTagInfo = createTagInfo(5);
            String access$000 = createTagInfo.tagName;
            log(i, access$000, str + createTagInfo.jumpInfo);
        }
    }

    private static void log(int i, String str, String str2) {
        if (sOutput) {
            SystemUtils.log(i, str, str2, (Throwable) null, "com.android.didi.bfflib.utils.BffLog", 195);
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

    private static TagInfo createTagInfo(int i) {
        TagInfo tagInfo = new TagInfo();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= i) {
            String unused = tagInfo.tagName = sTAG;
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
