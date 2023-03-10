package com.google.maps.android.p219ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* renamed from: com.google.maps.android.ui.SquareTextView */
public class SquareTextView extends AppCompatTextView {
    private int mOffsetLeft = 0;
    private int mOffsetTop = 0;

    public SquareTextView(Context context) {
        super(context);
    }

    public SquareTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        if (measuredWidth > measuredHeight) {
            this.mOffsetTop = measuredWidth - measuredHeight;
            this.mOffsetLeft = 0;
        } else {
            this.mOffsetTop = 0;
            this.mOffsetLeft = measuredHeight - measuredWidth;
        }
        setMeasuredDimension(max, max);
    }

    public void draw(Canvas canvas) {
        canvas.translate((float) (this.mOffsetLeft / 2), (float) (this.mOffsetTop / 2));
        super.draw(canvas);
    }
}
