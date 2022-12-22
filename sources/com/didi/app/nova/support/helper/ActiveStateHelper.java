package com.didi.app.nova.support.helper;

public class ActiveStateHelper {
    protected boolean mActive = false;

    public void active() {
        this.mActive = true;
    }

    public void inactive() {
        this.mActive = false;
    }

    public boolean isActive() {
        return this.mActive;
    }
}
