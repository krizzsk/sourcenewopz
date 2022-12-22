package com.didi.trace.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface StepEvent {
    TraceAttribute[] attr() default {};

    boolean report() default false;

    String stepName() default "";

    String value();
}
