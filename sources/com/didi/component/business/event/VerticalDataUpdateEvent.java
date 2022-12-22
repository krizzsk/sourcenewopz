package com.didi.component.business.event;

public class VerticalDataUpdateEvent {
    public int bottomOffsetY = -1;
    public boolean canPullUp;
    public boolean isShowAnimation;
    public int offsetY;

    public VerticalDataUpdateEvent(int i, int i2, boolean z, boolean z2) {
        this.offsetY = i;
        this.isShowAnimation = z;
        this.canPullUp = z2;
        this.bottomOffsetY = i2;
    }
}
