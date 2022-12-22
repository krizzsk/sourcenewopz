package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background;

public interface ApplicationStateListener {
    void applicationBackgrounded(ApplicationStateEvent applicationStateEvent);

    void applicationForegrounded(ApplicationStateEvent applicationStateEvent);
}
