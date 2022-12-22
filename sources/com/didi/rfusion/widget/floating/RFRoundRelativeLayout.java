package com.didi.rfusion.widget.floating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;

class RFRoundRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private final Path f33570a;

    /* renamed from: b */
    private final Paint f33571b;

    /* renamed from: c */
    private final RectF f33572c;

    /* renamed from: d */
    private float f33573d;

    /* renamed from: e */
    private float f33574e;

    /* renamed from: f */
    private float f33575f;

    /* renamed from: g */
    private float f33576g;

    public RFRoundRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFRoundRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFRoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFRoundRelativeLayout);
        this.f33573d = obtainStyledAttributes.getDimension(3, 0.0f);
        this.f33574e = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f33575f = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f33576g = obtainStyledAttributes.getDimension(1, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        if (dimension >= 0.0f) {
            setRadius(dimension);
        }
        obtainStyledAttributes.recycle();
        this.f33570a = new Path();
        this.f33571b = new Paint(1);
        this.f33572c = new RectF();
        this.f33571b.setAntiAlias(true);
        this.f33571b.setDither(true);
        this.f33571b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRadius(float f) {
        this.f33576g = f;
        this.f33575f = f;
        this.f33574e = f;
        this.f33573d = f;
        postInvalidate();
    }

    public void setTopLeftRadius(float f) {
        this.f33573d = f;
        postInvalidate();
    }

    public void setTopRightRadius(float f) {
        this.f33574e = f;
        postInvalidate();
    }

    public void setBottomLeftRadius(float f) {
        this.f33575f = f;
        postInvalidate();
    }

    public void setBottomRightRadius(float f) {
        this.f33576g = f;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f33572c.set(0.0f, 0.0f, (float) i, (float) i2);
    }

    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m23656b(canvas);
        } else {
            m23655a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m23658d(canvas);
        } else {
            m23657c(canvas);
        }
    }

    /* renamed from: a */
    private void m23655a(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f33572c, (Paint) null, 31);
        super.draw(canvas);
        canvas.drawPath(m23654a(), this.f33571b);
        canvas.restore();
    }

    /* renamed from: b */
    private void m23656b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m23654a());
        super.draw(canvas);
        canvas.restore();
    }

    /* renamed from: c */
    private void m23657c(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f33572c, (Paint) null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(m23654a(), this.f33571b);
        canvas.restore();
    }

    /* renamed from: d */
    private void m23658d(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m23654a());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private Path m23654a() {
        this.f33570a.reset();
        Path path = this.f33570a;
        RectF rectF = this.f33572c;
        float f = this.f33573d;
        float f2 = this.f33574e;
        float f3 = this.f33575f;
        float f4 = this.f33576g;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
        return this.f33570a;
    }
}
