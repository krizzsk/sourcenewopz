package com.didi.dimina.container.bridge.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DMServiceSubBridgeModule {
    public static final int HIGH_LEVEL = 1;
    public static final int LOW_LEVEL = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PluginLevel {
    }

    int level() default 1;

    boolean preCreateInstance() default false;
}
