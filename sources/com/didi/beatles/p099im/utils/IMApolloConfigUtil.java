package com.didi.beatles.p099im.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

/* renamed from: com.didi.beatles.im.utils.IMApolloConfigUtil */
public final class IMApolloConfigUtil {

    /* renamed from: a */
    private static final String f9745a = IMApolloConfigUtil.class.getSimpleName();

    /* renamed from: a */
    private static String m6593a() {
        return "IM_Global_Android_Config";
    }

    public static int getImageBaseCompressQuality() {
        int intValue = ((Integer) m6592a("compress_base_quality", 60)).intValue();
        IMLog.m6631d(f9745a, C4234I.m6591t("[getImageBaseCompressQuality] baseCompressQuality=", Integer.valueOf(intValue)));
        return intValue;
    }

    /* renamed from: a */
    private static <T> T m6592a(String str, T t) {
        IToggle toggle = Apollo.getToggle(m6593a());
        return toggle.allow() ? toggle.getExperiment().getParam(str, t) : t;
    }
}
