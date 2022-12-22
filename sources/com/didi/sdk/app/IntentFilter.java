package com.didi.sdk.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IntentFilter {
    String[] actions() default {};

    String[] categories() default {};

    DataAuthority[] dataAuthorities() default {};

    DataPatternMatcherPart[] dataPaths() default {};

    String[] dataSchemes() default {};

    String[] dataTypes() default {};

    DataPatternMatcherPart[] schemeSpecificParts() default {};
}
