package com.didi.soda.nova.skeleton.dsl.annotations;

import com.didi.soda.nova.skeleton.dsl.DslComponent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Stub {
    Class<? extends DslComponent> component();

    int containerId();

    String tag() default "";
}
