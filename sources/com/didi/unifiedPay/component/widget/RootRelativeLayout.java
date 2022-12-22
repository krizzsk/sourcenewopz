package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class RootRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private boolean f44468a;

    public RootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
    }

    public boolean isIntercept() {
        return this.f44468a;
    }

    public void setIntercept(boolean z) {
        this.f44468a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f44468a;
    }
}
