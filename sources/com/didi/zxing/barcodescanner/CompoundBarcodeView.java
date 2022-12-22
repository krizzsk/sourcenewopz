package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class CompoundBarcodeView extends DecoratedBarcodeView {
    public CompoundBarcodeView(Context context) {
        super(context);
    }

    public CompoundBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompoundBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
