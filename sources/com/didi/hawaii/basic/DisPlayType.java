package com.didi.hawaii.basic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DisPlayType {
    public static final int HIDE = 0;
    public static final int SHOW = 1;
    public static final int UPDATE = 2;

    @Retention(RetentionPolicy.CLASS)
    public @interface StatusType {
    }
}
