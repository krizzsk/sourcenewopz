package com.didichuxing.omega.sdk.feedback.judgment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class SmartTextView extends TextView {
    private static final int DEFAULT_MAX_WIDTH = 800;
    private int maxWidth;
    private int smartHeight;
    private int smartWidth;

    public SmartTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SmartTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public void setSmartText(String str) {
        setText(str);
        int i = getResources().getDisplayMetrics().heightPixels;
        if (this.maxWidth == 0) {
            this.maxWidth = 800;
        }
        measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE));
        this.smartWidth = getMeasuredWidth() + getPaddingLeft() + getPaddingRight();
        this.smartHeight = getMeasuredHeight() + getPaddingBottom() + getPaddingTop();
    }

    public int getSmartWidth() {
        return this.smartWidth;
    }

    public int getSmartHeight() {
        return this.smartHeight;
    }
}
