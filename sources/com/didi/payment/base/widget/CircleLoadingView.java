package com.didi.payment.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.payment.base.utils.UIUtil;

public class CircleLoadingView extends AppCompatTextView {

    /* renamed from: f */
    private static double f30111f = 10.0d;

    /* renamed from: a */
    private Paint f30112a;

    /* renamed from: b */
    private int f30113b = Color.parseColor("#CCCCCC");

    /* renamed from: c */
    private int f30114c = Color.parseColor("#FF6F26");

    /* renamed from: d */
    private int f30115d = 10;

    /* renamed from: e */
    private double f30116e = 4.0d;

    /* renamed from: g */
    private RectF f30117g;

    public CircleLoadingView(Context context) {
        super(context);
        m21098a();
    }

    public CircleLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21098a();
    }

    public CircleLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21098a();
    }

    public void setProgress(double d) {
        this.f30116e = d;
    }

    /* renamed from: a */
    private void m21098a() {
        Paint paint = new Paint();
        this.f30112a = paint;
        paint.setColor(this.f30113b);
        this.f30112a.setStyle(Paint.Style.STROKE);
        this.f30112a.setAntiAlias(true);
        this.f30112a.setStrokeWidth((float) this.f30115d);
        this.f30115d = UIUtil.dip2px(getContext(), 10.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f30112a.setColor(this.f30113b);
        int i = measuredWidth / 2;
        canvas.drawCircle((float) i, (float) (measuredHeight / 2), (float) (i - this.f30115d), this.f30112a);
        int i2 = (int) ((this.f30116e / f30111f) * 360.0d);
        if (this.f30117g == null) {
            int i3 = this.f30115d;
            this.f30117g = new RectF((float) i3, (float) i3, (float) (measuredWidth - i3), (float) (measuredHeight - i3));
        }
        this.f30112a.setColor(this.f30114c);
        canvas.drawArc(this.f30117g, 0.0f, (float) i2, false, this.f30112a);
    }
}
