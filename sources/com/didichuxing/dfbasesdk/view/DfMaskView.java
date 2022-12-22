package com.didichuxing.dfbasesdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;

public class DfMaskView extends View {

    /* renamed from: a */
    private Paint f46903a;

    /* renamed from: b */
    private int f46904b = -1;

    /* renamed from: c */
    private Context f46905c;

    /* renamed from: d */
    private Path f46906d;

    /* renamed from: e */
    private Path f46907e;

    /* renamed from: f */
    private int f46908f;

    /* renamed from: g */
    private int f46909g;

    /* renamed from: h */
    private float f46910h = 0.75f;

    /* renamed from: i */
    private int f46911i;

    /* renamed from: j */
    private int f46912j;

    /* renamed from: k */
    private int f46913k;

    /* renamed from: l */
    private int f46914l;

    /* renamed from: m */
    private int f46915m;

    /* renamed from: n */
    private int f46916n;

    /* renamed from: o */
    private int f46917o;

    /* renamed from: p */
    private int f46918p;

    /* renamed from: q */
    private Rect f46919q = new Rect();

    public DfMaskView(Context context) {
        super(context);
        m33637a(context);
    }

    public DfMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33637a(context);
        m33639a(attributeSet);
    }

    /* renamed from: a */
    private void m33639a(AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = this.f46905c.obtainStyledAttributes(attributeSet, C10448R.styleable.DfMaskView);
            this.f46910h = obtainStyledAttributes.getFloat(3, this.f46910h);
            this.f46913k = obtainStyledAttributes.getDimensionPixelSize(5, this.f46913k);
            this.f46914l = obtainStyledAttributes.getDimensionPixelSize(1, this.f46914l);
            this.f46916n = obtainStyledAttributes.getColor(4, this.f46916n);
            this.f46915m = obtainStyledAttributes.getDimensionPixelSize(2, this.f46915m);
            this.f46917o = obtainStyledAttributes.getColor(0, this.f46917o);
            this.f46918p = (int) (((float) this.f46915m) * 0.5f);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DfMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33637a(context);
        m33639a(attributeSet);
    }

    /* renamed from: a */
    private void m33637a(Context context) {
        this.f46905c = context;
        Paint paint = new Paint();
        this.f46903a = paint;
        paint.setAntiAlias(true);
        this.f46903a.setStyle(Paint.Style.STROKE);
        this.f46906d = new Path();
        this.f46907e = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m33638a(canvas);
        m33640b(canvas);
    }

    /* renamed from: a */
    private void m33638a(Canvas canvas) {
        this.f46903a.setColor(this.f46904b);
        this.f46903a.setStrokeWidth(0.0f);
        this.f46903a.setStyle(Paint.Style.FILL);
        this.f46907e.moveTo(0.0f, 0.0f);
        this.f46907e.lineTo((float) this.f46919q.width(), 0.0f);
        this.f46907e.lineTo((float) this.f46919q.width(), (float) (this.f46919q.top + this.f46918p));
        this.f46907e.lineTo(0.0f, (float) (this.f46919q.top + this.f46918p));
        this.f46907e.close();
        canvas.drawPath(this.f46907e, this.f46903a);
        this.f46907e.reset();
        this.f46907e.moveTo(0.0f, (float) (this.f46919q.bottom - this.f46918p));
        this.f46907e.lineTo((float) this.f46919q.width(), (float) (this.f46919q.bottom - this.f46918p));
        this.f46907e.lineTo((float) this.f46919q.width(), (float) this.f46912j);
        this.f46907e.lineTo(0.0f, (float) this.f46912j);
        this.f46907e.close();
        canvas.drawPath(this.f46907e, this.f46903a);
        this.f46907e.reset();
        this.f46907e.reset();
        this.f46907e.moveTo(0.0f, 0.0f);
        this.f46907e.lineTo((float) this.f46918p, 0.0f);
        this.f46907e.lineTo((float) this.f46918p, (float) this.f46912j);
        this.f46907e.lineTo(0.0f, (float) this.f46912j);
        this.f46907e.close();
        canvas.drawPath(this.f46907e, this.f46903a);
        this.f46907e.reset();
        this.f46907e.reset();
        this.f46907e.moveTo((float) (this.f46919q.width() - this.f46918p), 0.0f);
        this.f46907e.lineTo((float) this.f46919q.width(), 0.0f);
        this.f46907e.lineTo((float) this.f46919q.width(), (float) this.f46912j);
        this.f46907e.lineTo((float) (this.f46919q.width() - this.f46918p), (float) this.f46912j);
        this.f46907e.close();
        canvas.drawPath(this.f46907e, this.f46903a);
        this.f46907e.reset();
    }

    /* renamed from: b */
    private void m33640b(Canvas canvas) {
        this.f46903a.setStyle(Paint.Style.STROKE);
        this.f46903a.setColor(this.f46917o);
        this.f46903a.setStrokeWidth((float) this.f46915m);
        this.f46906d.reset();
        this.f46906d.moveTo((float) this.f46918p, (float) (this.f46919q.top + this.f46914l));
        this.f46906d.lineTo((float) this.f46918p, (float) (this.f46919q.top + this.f46918p));
        this.f46906d.lineTo((float) this.f46914l, (float) (this.f46919q.top + this.f46918p));
        canvas.drawPath(this.f46906d, this.f46903a);
        this.f46906d.reset();
        this.f46906d.moveTo((float) (this.f46919q.width() - this.f46914l), (float) (this.f46919q.top + this.f46918p));
        this.f46906d.lineTo((float) (this.f46919q.width() - this.f46918p), (float) (this.f46919q.top + this.f46918p));
        this.f46906d.lineTo((float) (this.f46919q.width() - this.f46918p), (float) (this.f46919q.top + this.f46914l));
        canvas.drawPath(this.f46906d, this.f46903a);
        this.f46906d.reset();
        this.f46906d.moveTo((float) this.f46918p, (float) (this.f46919q.bottom - this.f46914l));
        this.f46906d.lineTo((float) this.f46918p, (float) (this.f46919q.bottom - this.f46918p));
        this.f46906d.lineTo((float) this.f46914l, (float) (this.f46919q.bottom - this.f46918p));
        canvas.drawPath(this.f46906d, this.f46903a);
        this.f46906d.reset();
        this.f46906d.moveTo((float) (this.f46919q.width() - this.f46914l), (float) (this.f46919q.bottom - this.f46918p));
        this.f46906d.lineTo((float) (this.f46919q.width() - this.f46918p), (float) (this.f46919q.bottom - this.f46918p));
        this.f46906d.lineTo((float) (this.f46919q.width() - this.f46918p), (float) (this.f46919q.bottom - this.f46914l));
        canvas.drawPath(this.f46906d, this.f46903a);
        this.f46906d.reset();
        this.f46903a.setColor(this.f46916n);
        this.f46903a.setStrokeWidth((float) this.f46913k);
        this.f46906d.moveTo((float) this.f46918p, (float) (this.f46919q.top + this.f46918p));
        this.f46906d.lineTo((float) (this.f46919q.width() - this.f46918p), (float) (this.f46919q.top + this.f46918p));
        this.f46906d.lineTo((float) (this.f46919q.width() - this.f46918p), (float) (this.f46919q.bottom - this.f46918p));
        this.f46906d.lineTo((float) this.f46918p, (float) (this.f46919q.bottom - this.f46918p));
        this.f46906d.close();
        canvas.drawPath(this.f46906d, this.f46903a);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f46911i = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f46912j = measuredHeight;
        int i3 = this.f46911i;
        this.f46908f = i3;
        int i4 = (int) (((float) i3) / this.f46910h);
        this.f46909g = i4;
        int i5 = (int) (((float) (measuredHeight - i4)) * 0.5f);
        this.f46919q.set(0, i5, i3, i4 + i5);
    }

    public Rect getMaskRect() {
        return this.f46919q;
    }
}
