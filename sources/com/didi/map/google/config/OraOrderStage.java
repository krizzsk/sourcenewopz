package com.didi.map.google.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface OraOrderStage {
    public static final int FINISH = 5;
    public static final int PICKUP = 1;
    public static final int SENDOFF = 4;
    public static final int WAIT = 2;
}
