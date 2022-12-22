package com.didi.hawaii.log;

import android.content.Context;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didi.hawaii.utils.StorageUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public final class LoggerInit {

    /* renamed from: a */
    private static final String f23472a = "hawaii_android_log_control";

    /* renamed from: b */
    private static final String f23473b = "nav_log";

    /* renamed from: c */
    private static final String f23474c = "bm_log";

    /* renamed from: d */
    private static final String f23475d = "binary_log";

    /* renamed from: e */
    private static final String f23476e = "jni_log";

    /* renamed from: f */
    private static final String f23477f = "19900000000";

    /* renamed from: g */
    private static final String f23478g = (StorageUtils.getSDRootPath() + "/.WL/");

    /* renamed from: h */
    private static DelOldLogHandler f23479h = new DelOldLogHandler();

    private LoggerInit() {
    }

    public static void initAll(Context context) {
        initAll(context, false);
    }

    public static void initAll(Context context, boolean z) {
        if (context != null) {
            StorageUtils.init(context);
            m16765a();
            if (ApolloHawaii.isDelOldLogFile()) {
                f23479h.startDelOldLog();
            }
            if (z) {
                setPhoneNumber(f23477f);
                setPath(f23478g);
            }
        }
    }

    /* renamed from: a */
    private static void m16765a() {
        int i;
        int i2;
        int i3;
        IToggle toggle = Apollo.getToggle(f23472a);
        int i4 = 4;
        if (toggle.allow()) {
            i4 = ((Integer) toggle.getExperiment().getParam(f23473b, 4)).intValue();
            i2 = ((Integer) toggle.getExperiment().getParam(f23474c, 4)).intValue();
            i = ((Integer) toggle.getExperiment().getParam(f23475d, 4)).intValue();
            i3 = ((Integer) toggle.getExperiment().getParam(f23476e, 4)).intValue();
        } else {
            i3 = 4;
            i2 = 4;
            i = 4;
        }
        HWLog.initControlLevel(i4, i2, i, i3);
    }

    public static void setPhoneNumber(String str) {
        C8943c.m16778a(str);
        C8941a.m16767a(str);
    }

    public static void setPath(String str) {
        C8943c.m16782b(str);
        C8941a.m16771b(str);
    }
}
