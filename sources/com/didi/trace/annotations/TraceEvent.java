package com.didi.trace.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TraceEvent {
    TraceAttribute[] attr() default {};

    boolean time() default false;

    String value();
}
