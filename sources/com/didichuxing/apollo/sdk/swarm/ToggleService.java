package com.didichuxing.apollo.sdk.swarm;

import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public interface ToggleService {
    void addToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener);

    Boolean allow(String str);

    IToggle getToggle(String str);

    void removeToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener);
}
