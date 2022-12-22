package com.didi.soda.compose.log;

import android.util.Log;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.compose.ComposeEngine;
import com.didi.soda.compose.log.ComposeRecordTracker;

public final class ComposeLogUtil {

    /* renamed from: a */
    private static final boolean f40129a = ComposeEngine.DEBUG;

    private ComposeLogUtil() {
    }

    /* renamed from: d */
    public static void m28544d(String str, String str2) {
        if (f40129a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: i */
    public static void m28548i(String str, String str2) {
        m28547i(str, (ComposeIMessageGenerator<String>) new ComposeRecordTracker.RecordTrakerGeneratorCompose(str, str2));
    }

    /* renamed from: i */
    public static void m28547i(String str, ComposeIMessageGenerator<String> composeIMessageGenerator) {
        String build = composeIMessageGenerator.build();
        if (f40129a) {
            Log.i(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").info(build, new Object[0]);
        }
    }

    /* renamed from: w */
    public static void m28550w(String str, String str2) {
        m28549w(str, (ComposeIMessageGenerator<String>) new ComposeRecordTracker.RecordTrakerGeneratorCompose(str, str2));
    }

    /* renamed from: w */
    public static void m28549w(String str, ComposeIMessageGenerator<String> composeIMessageGenerator) {
        String build = composeIMessageGenerator.build();
        if (f40129a) {
            Log.w(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").warn(build, new Object[0]);
        }
    }

    /* renamed from: e */
    public static void m28546e(String str, String str2) {
        m28545e(str, (ComposeIMessageGenerator<String>) new ComposeRecordTracker.RecordTrakerGeneratorCompose(str, str2));
    }

    /* renamed from: e */
    public static void m28545e(String str, ComposeIMessageGenerator<String> composeIMessageGenerator) {
        String build = composeIMessageGenerator.build();
        if (f40129a) {
            Log.e(str, build);
        } else {
            LoggerFactory.getLogger("SodaAnd_p").error(build, new Object[0]);
        }
    }
}
