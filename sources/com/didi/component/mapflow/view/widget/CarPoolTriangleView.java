package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CarPoolTriangleView extends View {

    /* renamed from: a */
    private Paint f14513a;

    /* renamed from: b */
    private Path f14514b;

    public CarPoolTriangleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10311a();
    }

    /* renamed from: a */
    private void m10311a() {
        Paint paint = new Paint(1);
        this.f14513a = paint;
        paint.setColor(Color.parseColor("#27A5FF"));
        this.f14513a.setStrokeJoin(Paint.Join.ROUND);
        this.f14514b = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        this.f14514b.reset();
        this.f14514b.moveTo((float) (getWidth() / 2), 0.0f);
        this.f14514b.lineTo((float) getWidth(), (float) getHeight());
        this.f14514b.lineTo(0.0f, (float) getHeight());
        this.f14514b.close();
        canvas.drawPath(this.f14514b, this.f14513a);
    }
}
