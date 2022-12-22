package com.didi.soda.customer.foundation.log.util;

import android.util.Log;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.log.IMessageGenerator;
import com.didi.soda.customer.foundation.log.RecordTracker;

public final class LogUtil {

    /* renamed from: a */
    private static final boolean f40950a = CustomerToolBoxUtil.DEBUG;

    private LogUtil() {
    }

    /* renamed from: d */
    public static void m29100d(String str, String str2) {
        if (f40950a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: i */
    public static void m29104i(String str, String str2) {
        m29103i(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: i */
    public static void m29103i(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f40950a) {
            Log.i(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").info(build, new Object[0]);
        }
    }

    /* renamed from: w */
    public static void m29106w(String str, String str2) {
        m29105w(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: w */
    public static void m29105w(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f40950a) {
            Log.w(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").warn(build, new Object[0]);
        }
    }

    /* renamed from: e */
    public static void m29102e(String str, String str2) {
        m29101e(str, (IMessageGenerator<String>) new RecordTracker.RecordTrakerGenerator(str, str2));
    }

    /* renamed from: e */
    public static void m29101e(String str, IMessageGenerator<String> iMessageGenerator) {
        String build = iMessageGenerator.build();
        if (f40950a) {
            Log.e(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").error(build, new Object[0]);
        }
    }
}
