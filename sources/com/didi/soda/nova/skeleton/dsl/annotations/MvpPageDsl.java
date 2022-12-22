package com.didi.soda.nova.skeleton.dsl.annotations;

import com.didi.soda.nova.skeleton.dsl.DslIPresenter;
import com.didi.soda.nova.skeleton.dsl.DslIView;
import com.didi.soda.nova.skeleton.dsl.NullObject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MvpPageDsl {
    Stub[] components() default {};

    int layout() default 0;

    Class<? extends DslIPresenter> presenter() default NullObject.class;

    String tag() default "";

    int title() default 0;

    String titleString() default "";

    Class<? extends DslIView> view() default NullObject.class;
}
