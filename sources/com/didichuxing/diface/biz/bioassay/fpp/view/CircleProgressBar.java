package com.didichuxing.diface.biz.bioassay.fpp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.taxis99.R;

public class CircleProgressBar extends View {

    /* renamed from: b */
    private static final int f47253b = 20;

    /* renamed from: c */
    private static final int f47254c = 75;

    /* renamed from: a */
    SweepGradient f47255a;

    /* renamed from: d */
    private final TextPaint f47256d;

    /* renamed from: e */
    private int f47257e;

    /* renamed from: f */
    private int f47258f;

    /* renamed from: g */
    private Paint f47259g;

    /* renamed from: h */
    private RectF f47260h;

    /* renamed from: i */
    private int f47261i;

    /* renamed from: j */
    private int f47262j;

    /* renamed from: k */
    private Bitmap f47263k;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47255a = null;
        this.f47257e = 100;
        this.f47258f = 100;
        this.f47261i = 20;
        this.f47262j = 75;
        this.f47259g = new Paint();
        this.f47260h = new RectF();
        this.f47256d = new TextPaint();
        this.f47255a = new SweepGradient((float) (getWidth() / 2), (float) (getHeight() / 2), new int[]{-91506, -12594716, -2320754}, (float[]) null);
    }

    public int getMax() {
        return this.f47258f;
    }

    public void setMax(int i) {
        this.f47258f = i;
    }

    public int getProgress() {
        return this.f47257e;
    }

    public void setProgress(int i) {
        this.f47257e = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size > size2) {
            size = size2;
        }
        try {
            this.f47261i = (size * 20) / 190;
            this.f47262j = (size * 75) / 190;
        } catch (Exception unused) {
            this.f47261i = 1;
            this.f47262j = 1;
        }
        setMeasuredDimension(size, size);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f47259g.setAntiAlias(true);
        this.f47259g.setFlags(1);
        this.f47259g.setColor(-2565928);
        this.f47259g.setStrokeWidth((float) this.f47261i);
        this.f47259g.setStyle(Paint.Style.STROKE);
        int i = this.f47261i;
        int i2 = this.f47262j;
        canvas.drawCircle((float) (i + i2), (float) (i + i2), (float) i2, this.f47259g);
        this.f47259g.setColor(getContext().getResources().getColor(R.color.blue_bioassay_anim_hint));
        RectF rectF = this.f47260h;
        int i3 = this.f47261i;
        int i4 = this.f47262j;
        rectF.set((float) i3, (float) i3, (float) ((i4 * 2) + i3), (float) ((i4 * 2) + i3));
        canvas.drawArc(this.f47260h, -90.0f, (((float) this.f47257e) / ((float) this.f47258f)) * 360.0f, false, this.f47259g);
        this.f47259g.reset();
    }
}
