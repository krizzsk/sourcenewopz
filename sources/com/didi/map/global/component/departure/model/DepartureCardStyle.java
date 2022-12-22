package com.didi.map.global.component.departure.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DepartureCardStyle {
    public static final int DEFAULT = 0;
    public static final int DEPARTURE_CONFIRM = 1;
}
