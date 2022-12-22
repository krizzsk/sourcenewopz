package com.didi.global.map.animation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SodaAnimState {
    public static final int D_DELIVERY_COMPLETE = 4;
    public static final int D_FOOD_READY = 2;
    public static final int D_TO_DELIVER = 3;
    public static final int D_TO_TAKE = 1;
    public static final int UNKNOWN = 0;
}
