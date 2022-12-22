package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation;

public @interface ReplaceCallSite {
    boolean isStatic() default false;

    String scope() default "";
}
