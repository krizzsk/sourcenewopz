package com.didi.universal.pay.sdk.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;

public class LogUtil {
    public static final boolean debug = false;
    private static String sTAG = "universal_pay_log";

    /* renamed from: d */
    public static void m32408d(String str, String str2) {
    }

    /* renamed from: fi */
    public static void m32409fi(String str) {
        m32410fi(sTAG, str);
    }

    /* renamed from: fi */
    public static void m32410fi(String str, String str2) {
        Logger logger = LoggerFactory.getLogger(sTAG);
        TagInfo createTagInfo = createTagInfo(4);
        m32408d(str, str2);
        logger.info("%s %s %s", createTagInfo.tagName, str2, createTagInfo.jumpInfo);
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
