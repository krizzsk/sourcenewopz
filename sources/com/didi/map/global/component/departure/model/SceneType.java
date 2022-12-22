package com.didi.map.global.component.departure.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SceneType {
    public static final int CANOE_END_DRAG = 4;
    public static final int CANOE_HOME = 3;
    public static final int CANOE_START_DRAG = 5;
    public static final int CARPOOL_ONE = 1;
    public static final int CARPOOL_TWO = 2;
    public static final int DEFAULT = 0;
}
