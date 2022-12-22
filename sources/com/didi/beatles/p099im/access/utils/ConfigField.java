package com.didi.beatles.p099im.access.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.didi.beatles.im.access.utils.ConfigField */
public @interface ConfigField {
    int tag();
}
