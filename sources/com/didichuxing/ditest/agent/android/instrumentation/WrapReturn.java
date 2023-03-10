package com.didichuxing.ditest.agent.android.instrumentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
public @interface WrapReturn {
    String className();

    String methodDesc();

    String methodName();
}
