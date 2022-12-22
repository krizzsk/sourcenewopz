package com.didichuxing.mas.sdk.quality.init;

public interface IMASToggleService {

    public interface ToggleStateChangeListener {
        void onStateChanged();
    }

    void addToggleStateChangeListener(ToggleStateChangeListener toggleStateChangeListener);

    boolean allow(String str);

    <T> T getParams(String str, String str2, T t);

    void removeToggleStateChangeListener(ToggleStateChangeListener toggleStateChangeListener);
}
