package com.didi.component.common.widget.divider;

import android.view.MotionEvent;

public interface IMovePublisher {

    public interface OnMoveListener {
        void onEnd(boolean z, boolean z2);

        void onMove(float f, float f2);
    }

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    boolean onTouchEvent(MotionEvent motionEvent);

    void setOnMoveListener(OnMoveListener onMoveListener);
}
