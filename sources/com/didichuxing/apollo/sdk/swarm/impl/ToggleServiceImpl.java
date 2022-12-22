package com.didichuxing.apollo.sdk.swarm.impl;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.apollo.sdk.swarm.ToggleService;

public class ToggleServiceImpl implements ToggleService {
    public IToggle getToggle(String str) {
        return Apollo.getToggle(str);
    }

    public Boolean allow(String str) {
        return Boolean.valueOf(Apollo.getToggle(str).allow());
    }

    public void addToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        Apollo.addToggleStateChangeListener(onToggleStateChangeListener);
    }

    public void removeToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        Apollo.removeToggleStateChangeListener(onToggleStateChangeListener);
    }
}
