package com.didi.map.global.component.departure.wheel;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.didi.map.global.component.departure.wheel.-$$Lambda$WheelView$ruIXI3_FKPNDIqbFVy2nOwP0xcc  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$WheelView$ruIXI3_FKPNDIqbFVy2nOwP0xcc implements View.OnTouchListener {
    public static final /* synthetic */ $$Lambda$WheelView$ruIXI3_FKPNDIqbFVy2nOwP0xcc INSTANCE = new $$Lambda$WheelView$ruIXI3_FKPNDIqbFVy2nOwP0xcc();

    private /* synthetic */ $$Lambda$WheelView$ruIXI3_FKPNDIqbFVy2nOwP0xcc() {
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return view.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
