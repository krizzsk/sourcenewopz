package com.didi.soda.customer.p165h5.invokejs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.didi.soda.customer.h5.invokejs.Trigger */
public @interface Trigger {
    String name();
}
