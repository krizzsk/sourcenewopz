package com.didi.sdk.view.timepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;

@Deprecated
public class TimePickerView extends LinearLayout {
    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.layout.time_picker_three, this);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        float maxTextHeight = ((Wheel) getChildAt(0)).getMaxTextHeight();
        float f = (((float) measuredHeight) - maxTextHeight) / 2.0f;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.wheelview_shadow));
        Paint paint2 = paint;
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), f, paint2);
        float f2 = f + maxTextHeight;
        canvas.drawRect(0.0f, f2, (float) getMeasuredWidth(), (2.0f * f) + maxTextHeight, paint2);
        paint.setColor(getResources().getColor(R.color.light_gray_s));
        float f3 = (float) ((int) (getResources().getDisplayMetrics().density * 10.0f));
        float f4 = f - f3;
        Canvas canvas2 = canvas;
        canvas2.drawLine(0.0f, f4, (float) getMeasuredWidth(), f4, paint2);
        float f5 = f2 + f3;
        canvas2.drawLine(0.0f, f5, (float) getMeasuredWidth(), f5, paint2);
    }
}
