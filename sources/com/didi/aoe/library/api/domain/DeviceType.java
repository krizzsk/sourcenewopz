package com.didi.aoe.library.api.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DeviceType {
    public static final String CPU = "cpu";
    public static final String GPU = "gpu";
}
