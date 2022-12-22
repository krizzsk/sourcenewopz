package com.didi.entrega.router.annotations;

import com.didi.entrega.router.IInterceptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {
    Class<? extends IInterceptor>[] interceptors() default {};

    String[] value();
}
