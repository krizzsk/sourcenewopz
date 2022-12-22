package com.didi.drouter.annotation;

import com.didi.drouter.router.IRouterInterceptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Router {
    boolean hold() default false;

    String host() default "";

    Class<? extends IRouterInterceptor>[] interceptor() default {};

    String path() default "";

    int priority() default 0;

    String scheme() default "";

    int thread() default 0;

    String uri() default "";
}
