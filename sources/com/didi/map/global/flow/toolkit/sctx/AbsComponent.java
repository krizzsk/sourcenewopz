package com.didi.map.global.flow.toolkit.sctx;

public abstract class AbsComponent<T> {
    public abstract void destroy();

    public boolean isVisible() {
        return false;
    }

    public abstract void onMapVisible(boolean z);

    public void update(T t) {
    }

    public void visible(boolean z) {
    }
}
