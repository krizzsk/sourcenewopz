package com.didi.component.business.event;

public class NonTalkingVisibilityEvent {
    public boolean isVisible;
    public int mViewHeight;

    public NonTalkingVisibilityEvent(int i, boolean z) {
        this.mViewHeight = i;
        this.isVisible = z;
    }
}
