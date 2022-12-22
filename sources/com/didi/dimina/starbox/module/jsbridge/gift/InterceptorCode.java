package com.didi.dimina.starbox.module.jsbridge.gift;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface InterceptorCode {
    public static final int COMPLETE = 3;
    public static final int FAILED = 2;
    public static final int SUCCESS = 1;
}
