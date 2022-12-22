package com.didi.address.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface WayPointType {
    public static final int END = 3;
    public static final int START = 1;
    public static final int WAYPOINT = 2;
}
