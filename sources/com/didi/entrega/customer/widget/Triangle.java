package com.didi.entrega.customer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Triangle extends View {

    /* renamed from: a */
    private boolean f20360a = false;

    /* renamed from: b */
    private Paint f20361b;

    /* renamed from: c */
    private Path f20362c;

    public Triangle(Context context) {
        super(context);
        m14922a();
    }

    public Triangle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14922a();
    }

    public Triangle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14922a();
    }

    public void enableInverted() {
        this.f20360a = true;
        m14923a(getWidth(), getHeight());
    }

    public void onDraw(Canvas canvas) {
        Path path = this.f20362c;
        if (path != null) {
            canvas.drawPath(path, this.f20361b);
        }
        super.onDraw(canvas);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m14923a(i, i2);
    }

    public void setFillColor(int i) {
        this.f20361b.setColor(i);
        invalidate();
    }

    /* renamed from: a */
    private void m14922a() {
        Paint paint = new Paint(1);
        this.f20361b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f20361b.setStrokeWidth(2.0f);
    }

    /* renamed from: a */
    private void m14923a(int i, int i2) {
        Path path = new Path();
        this.f20362c = path;
        if (this.f20360a) {
            path.moveTo((float) (i / 2), (float) i2);
            this.f20362c.lineTo((float) i, 0.0f);
            this.f20362c.lineTo(0.0f, 0.0f);
        } else {
            path.moveTo((float) (i / 2), 0.0f);
            float f = (float) i2;
            this.f20362c.lineTo((float) i, f);
            this.f20362c.lineTo(0.0f, f);
        }
        this.f20362c.close();
    }
}
