package com.didi.map.setting.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DayNightMode {
    public static final int AUTO = 0;
    public static final int DAY = 1;
    public static final int NIGHT = 2;
}
