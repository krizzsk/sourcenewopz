package com.didi.component;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class Component extends View {
    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public Component(Context context) {
        super(context);
    }

    public Component(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Component(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Component(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }
}
