package com.didichuxing.apollo.sdk.observer;

import com.didichuxing.apollo.sdk.IToggle;
import java.util.EventObject;

public class ToggleStateChangeEvent extends EventObject {
    private final IToggle newToggle;
    private final IToggle oldToggle;

    public ToggleStateChangeEvent(Object obj, IToggle iToggle, IToggle iToggle2) {
        super(obj);
        this.oldToggle = iToggle;
        this.newToggle = iToggle2;
    }

    public IToggle getOldToggle() {
        return this.oldToggle;
    }

    public IToggle getNewToggle() {
        return this.newToggle;
    }
}
