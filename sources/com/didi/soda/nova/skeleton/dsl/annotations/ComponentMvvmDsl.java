package com.didi.soda.nova.skeleton.dsl.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentMvvmDsl {
    int layout() default 0;

    ViewModelStub[] viewModels() default {};
}
