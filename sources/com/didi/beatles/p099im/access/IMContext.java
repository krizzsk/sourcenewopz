package com.didi.beatles.p099im.access;

import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.style.custom.IMCustomResBuilder;
import com.didi.beatles.p099im.access.style.custom.IMCustomViewBuilder;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;

/* renamed from: com.didi.beatles.im.access.IMContext */
public abstract class IMContext extends IMCommonContext {
    public IMCustomResBuilder getCustomResBuilder() {
        return null;
    }

    public IMCustomViewBuilder getCustomViewBuilder() {
        return null;
    }

    public IMBusinessConfig getDefaultBusinessConfig() {
        return null;
    }

    public IMStyleManager.Style getIMStyle() {
        return IMStyleManager.Style.DEFAULT;
    }
}
