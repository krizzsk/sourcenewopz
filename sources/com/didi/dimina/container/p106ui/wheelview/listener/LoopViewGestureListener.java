package com.didi.dimina.container.p106ui.wheelview.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.didi.dimina.container.p106ui.wheelview.view.WheelView;

/* renamed from: com.didi.dimina.container.ui.wheelview.listener.LoopViewGestureListener */
public final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    private final WheelView f17872a;

    public LoopViewGestureListener(WheelView wheelView) {
        this.f17872a = wheelView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f17872a.scrollBy(f2);
        return true;
    }
}
