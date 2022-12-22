package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.didi.soda.customer.widget.support.CustomerCoordinatorLayout;

public class OrderCardCoordinatorLayout extends CustomerCoordinatorLayout {
    public OrderCardCoordinatorLayout(Context context) {
        super(context);
    }

    public OrderCardCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrderCardCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() >= 2 && (getChildAt(1) instanceof TouchEventSkippable)) {
            TouchEventSkippable touchEventSkippable = (TouchEventSkippable) getChildAt(1);
            if (touchEventSkippable.skipTouchEvent()) {
                touchEventSkippable.setSkipState(false);
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
