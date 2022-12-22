package com.didi.map.global.flow.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class ArrowView extends View {
    public ArrowView(Context context) {
        super(context);
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int height = getHeight();
        int width = getWidth();
        paint.setColor(Color.parseColor("#F25C6166"));
        Path path = new Path();
        float f = (float) height;
        path.moveTo(0.0f, f);
        path.lineTo((float) (width / 2), 0.0f);
        path.lineTo((float) width, f);
        path.close();
        canvas.drawPath(path, paint);
        super.onDraw(canvas);
    }
}
