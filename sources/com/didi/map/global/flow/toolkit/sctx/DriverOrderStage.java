package com.didi.map.global.flow.toolkit.sctx;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DriverOrderStage {
    public static final int PICKUP = 1;
    public static final int SENDOFF = 4;
    public static final int WAIT = 2;
}
