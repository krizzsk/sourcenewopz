package com.didichuxing.ditest.agent.android.background;

public interface ApplicationStateListener {
    void applicationBackgrounded(ApplicationStateEvent applicationStateEvent);

    void applicationForegrounded(ApplicationStateEvent applicationStateEvent);
}
