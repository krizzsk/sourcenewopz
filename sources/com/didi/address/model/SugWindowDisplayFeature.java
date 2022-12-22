package com.didi.address.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface SugWindowDisplayFeature {
    public static final int BOTTOM_DIALOG = 2;
    public static final int FULL_SCREEN = 1;
}
