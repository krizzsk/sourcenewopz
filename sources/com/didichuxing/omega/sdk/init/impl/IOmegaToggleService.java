package com.didichuxing.omega.sdk.init.impl;

public interface IOmegaToggleService {

    public interface ToggleStateChangeListener {
        void onStateChanged();
    }

    void addToggleStateChangeListener(ToggleStateChangeListener toggleStateChangeListener);

    boolean allow(String str);

    <T> T getParams(String str, String str2, T t);

    void removeToggleStateChangeListener(ToggleStateChangeListener toggleStateChangeListener);
}
