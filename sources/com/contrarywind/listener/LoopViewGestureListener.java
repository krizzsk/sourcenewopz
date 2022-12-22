package com.contrarywind.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.contrarywind.view.WheelView;

public final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    private final WheelView f3316a;

    public LoopViewGestureListener(WheelView wheelView) {
        this.f3316a = wheelView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f3316a.scrollBy(f2);
        return true;
    }
}
