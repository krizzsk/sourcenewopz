package com.didi.map.core.base.impl;

import android.graphics.PointF;

public interface OnMapGestureListener {
    boolean onDoubleTap(float f, float f2);

    boolean onDoubleTapDown(float f, float f2);

    boolean onDoubleTapMove(float f, float f2);

    boolean onDoubleTapUp(float f, float f2);

    boolean onDown(float f, float f2);

    boolean onFling(float f, float f2);

    boolean onLongPress(float f, float f2);

    boolean onMove(float f, float f2);

    boolean onScroll(float f, float f2);

    boolean onSingleTap(float f, float f2);

    void onSingleTapNotConfirm();

    boolean onTwoFingerDown();

    boolean onTwoFingerMoveAgainst(PointF pointF, PointF pointF2, double d, double d2);

    boolean onTwoFingerMoveHorizontal(float f);

    boolean onTwoFingerMoveVertical(float f);

    boolean onTwoFingerRotate(PointF pointF, PointF pointF2, float f);

    boolean onTwoFingerSingleTap(float f, float f2);

    boolean onTwoFingerUp();

    boolean onUp(float f, float f2);
}
