package com.didi.beatles.p099im.access.style.custom;

import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;

/* renamed from: com.didi.beatles.im.access.style.custom.IMCustomResHelper */
public final class IMCustomResHelper {
    public static IMCustomResBuilder get(IMBusinessConfig iMBusinessConfig) {
        if (iMBusinessConfig == null) {
            return IMCustomResBuilder.EMPTY;
        }
        IMCustomResBuilder customResBuilder = iMBusinessConfig.getCustomResBuilder();
        if (customResBuilder != null) {
            return customResBuilder;
        }
        IMCustomResBuilder customResBuilder2 = IMContextInfoHelper.getCustomResBuilder();
        if (customResBuilder2 != null) {
            return customResBuilder2;
        }
        return IMCustomResBuilder.EMPTY;
    }
}
