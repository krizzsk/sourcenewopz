package com.didi.component.business.event;

public class OpenRideVisibilityEvent {
    public boolean isVisiable;
    public int mViewHeight;

    public OpenRideVisibilityEvent(int i, boolean z) {
        this.mViewHeight = i;
        this.isVisiable = z;
    }
}
