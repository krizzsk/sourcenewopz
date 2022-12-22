package com.didi.map.core.base;

public interface OnMapScaleChangedListener {

    public enum ScaleChangedType {
        NO_CHANGED,
        SCALE_CHANGED,
        SCALE_LEVEL_CHANGED
    }

    void onScaleChanged(ScaleChangedType scaleChangedType);
}
