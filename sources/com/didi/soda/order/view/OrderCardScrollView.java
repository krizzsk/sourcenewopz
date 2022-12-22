package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;

public class OrderCardScrollView extends NestedScrollView implements TouchEventSkippable {

    /* renamed from: a */
    private boolean f43553a = false;

    public OrderCardScrollView(Context context) {
        super(context);
    }

    public OrderCardScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrderCardScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() > 0 && (getChildAt(0) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(0);
            if (viewGroup.getChildCount() > 0 && (viewGroup.getChildAt(0) instanceof TouchEventSkippable)) {
                TouchEventSkippable touchEventSkippable = (TouchEventSkippable) viewGroup.getChildAt(0);
                if (touchEventSkippable.skipTouchEvent()) {
                    touchEventSkippable.setSkipState(false);
                    setSkipState(true);
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSkipState(boolean z) {
        this.f43553a = z;
    }

    public boolean skipTouchEvent() {
        return this.f43553a;
    }
}
