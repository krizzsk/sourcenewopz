package com.didi.component.business.event;

public class SafeToolkitVisibilityEvent {
    public boolean isVisible;
    public int mViewHeight;

    public SafeToolkitVisibilityEvent(int i, boolean z) {
        this.mViewHeight = i;
        this.isVisible = z;
    }
}
