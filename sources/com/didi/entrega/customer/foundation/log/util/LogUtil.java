package com.didi.entrega.customer.foundation.log.util;

import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.log.IMessageGenerator;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.LoggerFactory;

public final class LogUtil {

    /* renamed from: a */
    private static final boolean f19943a = CustomerToolBoxUtil.DEBUG;

    private LogUtil() {
    }

    /* renamed from: d */
    public static void m14761d(String str, String str2) {
        if (f19943a) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 30);
        }
    }

    /* renamed from: i */
    public static void m14765i(String str, String str2) {
        m14764i(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: i */
    public static void m14764i(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f19943a) {
            SystemUtils.log(4, str, build, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 42);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").info(build, new Object[0]);
        }
    }

    /* renamed from: w */
    public static void m14767w(String str, String str2) {
        m14766w(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: w */
    public static void m14766w(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f19943a) {
            SystemUtils.log(5, str, build, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 57);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").warn(build, new Object[0]);
        }
    }

    /* renamed from: e */
    public static void m14763e(String str, String str2) {
        m14762e(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: e */
    public static void m14762e(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f19943a) {
            SystemUtils.log(6, str, build, (Throwable) null, "com.didi.entrega.customer.foundation.log.util.LogUtil", 72);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").error(build, new Object[0]);
        }
    }
}
