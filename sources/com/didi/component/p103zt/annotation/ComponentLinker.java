package com.didi.component.p103zt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* renamed from: com.didi.component.zt.annotation.ComponentLinker */
public @interface ComponentLinker {
    String alias() default "";

    ComponentAttribute attribute();

    int comboType() default 0;

    Class component();

    int maxSupportVersionCode() default 0;

    int minSupportVersionCode() default 0;

    int[] scene() default {0};

    Version version() default Version.V2;
}
