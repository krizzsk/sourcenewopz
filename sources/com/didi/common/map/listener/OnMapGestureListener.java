package com.didi.common.map.listener;

public interface OnMapGestureListener {
    boolean onDoubleTap(float f, float f2);

    boolean onDown(float f, float f2);

    boolean onFling(float f, float f2);

    boolean onLongPress(float f, float f2);

    void onMapStable();

    boolean onScroll(float f, float f2);

    boolean onSingleTap(float f, float f2);

    boolean onUp(float f, float f2);
}
