package com.didiglobal.p205sa.biz.component.ridecard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;

/* renamed from: com.didiglobal.sa.biz.component.ridecard.widget.MapMaskView */
public class MapMaskView extends View {
    public MapMaskView(Context context) {
        super(context);
    }

    public MapMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MapMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MapMaskView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PageTouchEventManger.mapConsume = true;
        return super.dispatchTouchEvent(motionEvent);
    }
}
