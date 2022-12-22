package com.didichuxing.xpanel.global.models.misoperation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MisOperationImageView extends ImageView {
    public MisOperationImageView(Context context) {
        super(context);
    }

    public MisOperationImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MisOperationImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (measuredWidth * 140) / 375);
    }
}
