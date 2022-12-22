package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.p190v2;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.v2.TraceMachineInterface */
public interface TraceMachineInterface {
    long getCurrentThreadId();

    String getCurrentThreadName();

    boolean isUIThread();
}
