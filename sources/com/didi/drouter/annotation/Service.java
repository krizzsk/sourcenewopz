package com.didi.drouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Service {
    String[] alias() default {};

    int cache() default 0;

    Class<?>[] feature() default {};

    Class<?>[] function();

    int priority() default 0;
}
