package com.didiglobal.p205sa.biz.weight.tkrefreshlayout;

import android.view.MotionEvent;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.OnGestureListener */
public interface OnGestureListener {
    void onDown(MotionEvent motionEvent);

    void onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    void onUp(MotionEvent motionEvent, boolean z);
}
