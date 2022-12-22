package com.didi.sdk.app;

public @interface DataPatternMatcherPart {
    int flag() default 0;

    String value() default "";
}
