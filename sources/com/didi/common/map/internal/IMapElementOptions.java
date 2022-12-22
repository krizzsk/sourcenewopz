package com.didi.common.map.internal;

public abstract class IMapElementOptions {
    protected boolean mClickable = false;
    protected boolean mVisible = true;
    protected int mZIndex = 0;

    public IMapElementOptions zIndex(int i) {
        this.mZIndex = i;
        return this;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public IMapElementOptions visible(boolean z) {
        this.mVisible = z;
        return this;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public IMapElementOptions clickable(boolean z) {
        this.mClickable = z;
        return this;
    }

    public boolean isClickable() {
        return this.mClickable;
    }
}
