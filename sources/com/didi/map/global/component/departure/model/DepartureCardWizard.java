package com.didi.map.global.component.departure.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface DepartureCardWizard {
    public static final int START_SET_PICKUP = 1;
    public static final int START_TERMINAL_SELECT = 3;
    public static final int START_UNKNOW = 0;
    public static final int START_WELCOME = 2;
}
