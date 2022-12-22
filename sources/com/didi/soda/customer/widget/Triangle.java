package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Triangle extends View {

    /* renamed from: a */
    private boolean f41606a = false;

    /* renamed from: b */
    private Paint f41607b;

    /* renamed from: c */
    private Path f41608c;

    public Triangle(Context context) {
        super(context);
        m29408a();
    }

    public Triangle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29408a();
    }

    public Triangle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29408a();
    }

    public void enableInverted() {
        this.f41606a = true;
        m29409a(getWidth(), getHeight());
    }

    public void onDraw(Canvas canvas) {
        Path path = this.f41608c;
        if (path != null) {
            canvas.drawPath(path, this.f41607b);
        }
        super.onDraw(canvas);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m29409a(i, i2);
    }

    public void setFillColor(int i) {
        this.f41607b.setColor(i);
        invalidate();
    }

    /* renamed from: a */
    private void m29408a() {
        Paint paint = new Paint(1);
        this.f41607b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f41607b.setStrokeWidth(2.0f);
    }

    /* renamed from: a */
    private void m29409a(int i, int i2) {
        Path path = new Path();
        this.f41608c = path;
        if (this.f41606a) {
            path.moveTo((float) (i / 2), (float) i2);
            this.f41608c.lineTo((float) i, 0.0f);
            this.f41608c.lineTo(0.0f, 0.0f);
        } else {
            path.moveTo((float) (i / 2), 0.0f);
            float f = (float) i2;
            this.f41608c.lineTo((float) i, f);
            this.f41608c.lineTo(0.0f, f);
        }
        this.f41608c.close();
    }
}
