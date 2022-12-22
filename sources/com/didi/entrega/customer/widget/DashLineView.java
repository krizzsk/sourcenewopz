package com.didi.entrega.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;

public class DashLineView extends View {

    /* renamed from: a */
    private static final int f20286a = 0;

    /* renamed from: b */
    private static final int f20287b = 0;

    /* renamed from: c */
    private static final int f20288c = 0;

    /* renamed from: d */
    private static final int f20289d = 0;

    /* renamed from: e */
    private static final int f20290e = 0;

    /* renamed from: f */
    private Paint f20291f;

    /* renamed from: g */
    private Path f20292g;

    /* renamed from: h */
    private int f20293h = 0;

    /* renamed from: i */
    private int f20294i = 0;

    /* renamed from: j */
    private int f20295j = 0;

    /* renamed from: k */
    private int f20296k = 0;

    /* renamed from: l */
    private int f20297l = 0;

    /* renamed from: m */
    private int f20298m;

    public DashLineView(Context context) {
        super(context);
        m14900a(context, (AttributeSet) null);
    }

    public DashLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14900a(context, attributeSet);
    }

    public DashLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14900a(context, attributeSet);
    }

    public void setDashStyle(int i, int i2, int i3, int i4) {
        this.f20293h = i;
        this.f20294i = i2;
        this.f20295j = i3;
        this.f20296k = i4;
        m14899a();
        postInvalidate();
    }

    public void setHeight(int i) {
        this.f20298m = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f20293h != 0) {
            if (this.f20297l == 0) {
                this.f20292g.reset();
                float height = (float) (getHeight() / 2);
                this.f20292g.moveTo(0.0f, height);
                this.f20292g.lineTo((float) getWidth(), height);
            } else {
                this.f20292g.reset();
                float width = (float) (getWidth() / 2);
                this.f20292g.moveTo(width, 0.0f);
                Path path = this.f20292g;
                int i = this.f20298m;
                if (i <= 0) {
                    i = getHeight();
                }
                path.lineTo(width, (float) i);
            }
            canvas.drawPath(this.f20292g, this.f20291f);
        }
    }

    /* renamed from: a */
    private void m14900a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaDashLineView);
            this.f20293h = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.f20294i = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f20295j = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f20296k = obtainStyledAttributes.getColor(0, 0);
            this.f20297l = obtainStyledAttributes.getInt(4, 0);
            obtainStyledAttributes.recycle();
        }
        m14899a();
    }

    /* renamed from: a */
    private void m14899a() {
        Paint paint = new Paint(1);
        this.f20291f = paint;
        paint.setColor(this.f20296k);
        this.f20291f.setStyle(Paint.Style.STROKE);
        this.f20291f.setStrokeWidth((float) this.f20293h);
        this.f20291f.setPathEffect(new DashPathEffect(new float[]{(float) this.f20294i, (float) this.f20295j}, 0.0f));
        this.f20292g = new Path();
    }
}
