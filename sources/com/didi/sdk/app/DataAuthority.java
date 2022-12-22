package com.didi.sdk.app;

public @interface DataAuthority {
    int port() default -1;

    String value() default "";
}
