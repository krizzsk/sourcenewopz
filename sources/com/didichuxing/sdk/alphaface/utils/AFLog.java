package com.didichuxing.sdk.alphaface.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;

public class AFLog {

    /* renamed from: a */
    private static final String f48756a = "af_default";

    /* renamed from: v */
    public static void m34998v(String str) {
        m34999v(f48756a, str);
    }

    /* renamed from: v */
    public static void m34999v(String str, String str2) {
        if (AlphaFaceFacade.getInstance().getConfig() != null && AlphaFaceFacade.getInstance().getConfig().isDebug()) {
            SystemUtils.log(2, str, str2, (Throwable) null, "com.didichuxing.sdk.alphaface.utils.AFLog", 22);
        }
    }

    /* renamed from: e */
    public static void m34996e(String str) {
        m34997e(f48756a, str);
    }

    /* renamed from: e */
    public static void m34997e(String str, String str2) {
        if (AlphaFaceFacade.getInstance().getConfig() != null && AlphaFaceFacade.getInstance().getConfig().isDebug()) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.didichuxing.sdk.alphaface.utils.AFLog", 34);
        }
    }
}
