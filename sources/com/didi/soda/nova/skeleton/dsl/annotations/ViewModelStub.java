package com.didi.soda.nova.skeleton.dsl.annotations;

import com.didi.soda.nova.skeleton.dsl.DslViewModel;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewModelStub {
    String variableId();

    Class<? extends DslViewModel> viewModel();
}
