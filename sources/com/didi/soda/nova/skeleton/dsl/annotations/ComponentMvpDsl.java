package com.didi.soda.nova.skeleton.dsl.annotations;

import com.didi.soda.nova.skeleton.dsl.DslIPresenter;
import com.didi.soda.nova.skeleton.dsl.DslIView;
import com.didi.soda.nova.skeleton.dsl.DslRepo;
import com.didi.soda.nova.skeleton.dsl.NullObject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentMvpDsl {
    Class<? extends DslIPresenter> presenter() default NullObject.class;

    @Deprecated
    Class<? extends DslRepo>[] repos() default {};

    Class<? extends DslIView> view() default NullObject.class;
}
