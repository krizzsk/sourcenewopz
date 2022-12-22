package com.didi.app.nova.skeleton.conductor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public class ChangeHandlerFrameLayout extends FrameLayout implements ControllerChangeHandler.ControllerChangeListener {

    /* renamed from: a */
    private int f8276a;

    public ChangeHandlerFrameLayout(Context context) {
        super(context);
    }

    public ChangeHandlerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeHandlerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ChangeHandlerFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f8276a > 0 || super.onInterceptTouchEvent(motionEvent);
    }

    public void onChangeStarted(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
        this.f8276a++;
    }

    public void onChangeCompleted(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
        this.f8276a--;
    }
}
