package com.didi.map.global.component.departure.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface DepartureZoneType {
    public static final int AROUND = 3;
    public static final int FENCE = 0;
    public static final int NOPARKING = 1;
    public static final int NORMAL = 2;
    public static final int UNKNOWN = -1;
}
