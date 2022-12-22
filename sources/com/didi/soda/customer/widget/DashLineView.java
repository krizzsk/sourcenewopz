package com.didi.soda.customer.widget;

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
    private static final int f41513a = 0;

    /* renamed from: b */
    private static final int f41514b = 0;

    /* renamed from: c */
    private static final int f41515c = 0;

    /* renamed from: d */
    private static final int f41516d = 0;

    /* renamed from: e */
    private static final int f41517e = 0;

    /* renamed from: f */
    private Paint f41518f;

    /* renamed from: g */
    private Path f41519g;

    /* renamed from: h */
    private int f41520h = 0;

    /* renamed from: i */
    private int f41521i = 0;

    /* renamed from: j */
    private int f41522j = 0;

    /* renamed from: k */
    private int f41523k = 0;

    /* renamed from: l */
    private int f41524l = 0;

    /* renamed from: m */
    private int f41525m;

    public DashLineView(Context context) {
        super(context);
        m29372a(context, (AttributeSet) null);
    }

    public DashLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29372a(context, attributeSet);
    }

    public DashLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29372a(context, attributeSet);
    }

    public void setDashStyle(int i, int i2, int i3, int i4) {
        this.f41520h = i;
        this.f41521i = i2;
        this.f41522j = i3;
        this.f41523k = i4;
        m29371a();
        postInvalidate();
    }

    public void setHeight(int i) {
        this.f41525m = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f41520h != 0) {
            if (this.f41524l == 0) {
                this.f41519g.reset();
                float height = (float) (getHeight() / 2);
                this.f41519g.moveTo(0.0f, height);
                this.f41519g.lineTo((float) getWidth(), height);
            } else {
                this.f41519g.reset();
                float width = (float) (getWidth() / 2);
                this.f41519g.moveTo(width, 0.0f);
                Path path = this.f41519g;
                int i = this.f41525m;
                if (i <= 0) {
                    i = getHeight();
                }
                path.lineTo(width, (float) i);
            }
            canvas.drawPath(this.f41519g, this.f41518f);
        }
    }

    /* renamed from: a */
    private void m29372a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.DashLineView);
            this.f41520h = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            this.f41521i = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f41522j = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f41523k = obtainStyledAttributes.getColor(0, 0);
            this.f41524l = obtainStyledAttributes.getInt(2, 0);
            obtainStyledAttributes.recycle();
        }
        m29371a();
    }

    /* renamed from: a */
    private void m29371a() {
        Paint paint = new Paint(1);
        this.f41518f = paint;
        paint.setColor(this.f41523k);
        this.f41518f.setStyle(Paint.Style.STROKE);
        this.f41518f.setStrokeWidth((float) this.f41520h);
        this.f41518f.setPathEffect(new DashPathEffect(new float[]{(float) this.f41521i, (float) this.f41522j}, 0.0f));
        this.f41519g = new Path();
    }
}
