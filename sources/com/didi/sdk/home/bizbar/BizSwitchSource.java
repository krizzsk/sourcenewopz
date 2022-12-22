package com.didi.sdk.home.bizbar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface BizSwitchSource {
    public static final int BIZ_EXTEND = 3;
    public static final int BIZ_MAIN = 1;
    public static final int BIZ_MORE = 2;
}
