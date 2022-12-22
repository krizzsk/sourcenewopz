package com.didi.component.evaluate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.component.evaluate.util.ViewUtil;

public class EvaluateRootContainer extends LinearLayout {

    /* renamed from: a */
    private boolean f13305a;

    /* renamed from: b */
    private OnTouchWhenInterceptListener f13306b;

    /* renamed from: c */
    private int f13307c;

    public interface OnTouchWhenInterceptListener {
        void onTouchWhenIntercept();
    }

    public EvaluateRootContainer(Context context) {
        super(context);
    }

    public EvaluateRootContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EvaluateRootContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EvaluateRootContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setOnTouchWhenInterceptListener(OnTouchWhenInterceptListener onTouchWhenInterceptListener) {
        this.f13306b = onTouchWhenInterceptListener;
    }

    public void setInterceptTouchEnable(boolean z) {
        this.f13305a = z;
    }

    public void setCanTouchView(int i) {
        this.f13307c = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f13305a) {
            return super.onTouchEvent(motionEvent);
        }
        OnTouchWhenInterceptListener onTouchWhenInterceptListener = this.f13306b;
        if (onTouchWhenInterceptListener == null) {
            return true;
        }
        onTouchWhenInterceptListener.onTouchWhenIntercept();
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f13305a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        View findViewById = findViewById(this.f13307c);
        if (findViewById == null || ViewUtil.isTouchPointInView(findViewById, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
