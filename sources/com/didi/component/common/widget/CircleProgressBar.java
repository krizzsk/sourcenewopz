package com.didi.component.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.didi.passenger.C10448R;

public class CircleProgressBar extends View {

    /* renamed from: a */
    private float f11965a = 4.0f;

    /* renamed from: b */
    private float f11966b = 0.0f;

    /* renamed from: c */
    private int f11967c = 0;

    /* renamed from: d */
    private int f11968d = 100;

    /* renamed from: e */
    private int f11969e = -90;

    /* renamed from: f */
    private int f11970f = -12303292;

    /* renamed from: g */
    private int f11971g = -7829368;

    /* renamed from: h */
    private RectF f11972h;

    /* renamed from: i */
    private Paint f11973i;

    /* renamed from: j */
    private Paint f11974j;

    /* renamed from: k */
    private boolean f11975k = false;

    /* renamed from: l */
    private int f11976l = 30;

    /* renamed from: m */
    private int[] f11977m;

    /* renamed from: n */
    private float[] f11978n;

    /* renamed from: o */
    private Matrix f11979o;

    /* renamed from: p */
    private Bitmap f11980p;

    /* renamed from: q */
    private float f11981q;

    public float getStrokeWidth() {
        return this.f11965a;
    }

    public void setStrokeWidth(float f) {
        this.f11965a = f;
        this.f11973i.setStrokeWidth(f);
        this.f11974j.setStrokeWidth(f);
        invalidate();
        requestLayout();
    }

    public float getProgress() {
        return this.f11966b;
    }

    public void setProgress(float f) {
        this.f11966b = f;
        invalidate();
    }

    public void setPercent(float f) {
        this.f11966b = f * ((float) getMax());
        invalidate();
    }

    public int getMin() {
        return this.f11967c;
    }

    public void setMin(int i) {
        this.f11967c = i;
        invalidate();
    }

    public int getMax() {
        return this.f11968d;
    }

    public void setMax(int i) {
        this.f11968d = i;
        invalidate();
    }

    public int getColor() {
        return this.f11970f;
    }

    public void setColor(int i) {
        this.f11970f = i;
        this.f11974j.setColor(i);
        invalidate();
        requestLayout();
    }

    public int getBackColor() {
        return this.f11971g;
    }

    public void setBackColor(int i) {
        this.f11971g = i;
        this.f11973i.setColor(i);
        invalidate();
        requestLayout();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8066a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private void m8066a(Context context, AttributeSet attributeSet) {
        this.f11972h = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.CircleProgressBar, 0, 0);
        try {
            this.f11965a = obtainStyledAttributes.getDimension(3, this.f11965a);
            this.f11966b = obtainStyledAttributes.getFloat(2, this.f11966b);
            int i = obtainStyledAttributes.getInt(5, this.f11970f);
            this.f11970f = i;
            this.f11971g = obtainStyledAttributes.getInt(4, i);
            this.f11967c = obtainStyledAttributes.getInt(1, this.f11967c);
            this.f11968d = obtainStyledAttributes.getInt(0, this.f11968d);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.f11973i = paint;
            paint.setColor(this.f11971g);
            this.f11973i.setStyle(Paint.Style.STROKE);
            this.f11973i.setStrokeWidth(this.f11965a);
            Paint paint2 = new Paint(1);
            this.f11974j = paint2;
            paint2.setColor(this.f11970f);
            this.f11974j.setStyle(Paint.Style.STROKE);
            this.f11974j.setStrokeWidth(this.f11965a);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (this.f11966b * 360.0f) / ((float) this.f11968d);
        canvas.drawArc(this.f11972h, (float) this.f11969e, f, false, this.f11974j);
        if (this.f11975k && f > ((float) this.f11976l)) {
            if (this.f11980p == null) {
                m8065a();
            }
            Matrix matrix = this.f11979o;
            if (matrix == null) {
                Matrix matrix2 = new Matrix();
                this.f11979o = matrix2;
                matrix2.postRotate(((180.0f + f) + ((float) this.f11969e)) - ((float) this.f11976l), this.f11972h.centerX(), this.f11972h.centerY());
                this.f11981q = f;
            } else {
                matrix.postRotate(f - this.f11981q, this.f11972h.centerX(), this.f11972h.centerY());
                this.f11981q = f;
            }
            canvas.drawBitmap(this.f11980p, this.f11979o, (Paint) null);
        }
    }

    /* renamed from: a */
    private void m8065a() {
        this.f11980p = Bitmap.createBitmap((int) ((Math.sin(Math.toRadians((double) this.f11976l)) * ((double) this.f11972h.width())) / 2.0d), ((int) this.f11972h.height()) / 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f11980p);
        canvas.drawColor(0);
        SweepGradient sweepGradient = new SweepGradient(this.f11972h.centerX(), this.f11972h.centerY(), this.f11977m, this.f11978n);
        Matrix matrix = new Matrix();
        matrix.postRotate(-180.0f, this.f11972h.centerX(), this.f11972h.centerY());
        sweepGradient.setLocalMatrix(matrix);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f11965a);
        paint.setShader(sweepGradient);
        canvas.drawArc(this.f11972h, -180.0f, (float) this.f11976l, false, paint);
    }

    public void setGradientStatus(boolean z) {
        this.f11975k = z;
        if (!z) {
            Bitmap bitmap = this.f11980p;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f11980p = null;
            this.f11979o = null;
        }
    }

    public void setGradientColor(int i, int i2, int i3) {
        this.f11976l = i3;
        this.f11977m = new int[]{i, i2};
        this.f11978n = new float[]{0.0f, ((float) i3) / 360.0f};
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        RectF rectF = this.f11972h;
        float f = this.f11965a;
        float f2 = (float) min;
        rectF.set((f / 2.0f) + 0.0f, (f / 2.0f) + 0.0f, f2 - (f / 2.0f), f2 - (f / 2.0f));
    }

    public int lightenColor(int i, float f) {
        float green = ((float) Color.green(i)) * f;
        float blue = ((float) Color.blue(i)) * f;
        return Color.argb(Color.alpha(i), Math.min(255, (int) (((float) Color.red(i)) * f)), Math.min(255, (int) green), Math.min(255, (int) blue));
    }

    public int adjustAlpha(int i, float f) {
        return Color.argb(Math.round(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public void setProgressWithAnimation(float f, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", new float[]{f});
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }
}
