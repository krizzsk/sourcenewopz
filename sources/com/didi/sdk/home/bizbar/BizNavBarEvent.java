package com.didi.sdk.home.bizbar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BizNavBarEvent {
    public static final int STATE_GONE_END = 4;
    public static final int STATE_GONE_START = 3;
    public static final int STATE_VISIBILE_END = 2;
    public static final int STATE_VISIBILE_START = 1;
    public int height;
    public int state;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavBarVisibilityState {
    }
}
