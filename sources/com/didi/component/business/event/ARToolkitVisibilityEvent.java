package com.didi.component.business.event;

public class ARToolkitVisibilityEvent {
    public boolean isVisiable;
    public int mViewHeight;

    public ARToolkitVisibilityEvent(int i, boolean z) {
        this.mViewHeight = i;
        this.isVisiable = z;
    }
}
