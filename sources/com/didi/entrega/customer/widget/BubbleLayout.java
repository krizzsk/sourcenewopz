package com.didi.entrega.customer.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class BubbleLayout extends LinearLayout {
    public static final int BOTTOM_LEFT = 4096;
    public static final int BOTTOM_MIDDLE = 8192;
    public static final int BOTTOM_RIGHT = 12288;
    public static final int LEFT_BOTTOM = 48;
    public static final int LEFT_MIDDLE = 32;
    public static final int LEFT_TOP = 16;
    public static final int NONE = 0;
    public static final int RIGHT_BOTTOM = 768;
    public static final int RIGHT_MIDDLE = 512;
    public static final int RIGHT_TOP = 256;
    public static final int TOP_LEFT = 1;
    public static final int TOP_MIDDLE = 2;
    public static final int TOP_RIGHT = 3;

    /* renamed from: a */
    private static int f20240a = 0;

    /* renamed from: b */
    private static int f20241b = 0;

    /* renamed from: c */
    private static float f20242c = 0.2f;
    public static float sCornerRadius;
    public static int sDefaultPaddingH;
    public static int sDefaultPaddingV;
    public static float sStrokeWidth;

    /* renamed from: d */
    private final Path f20243d;

    /* renamed from: e */
    private final Path f20244e;

    /* renamed from: f */
    private Paint f20245f;

    /* renamed from: g */
    private RectF f20246g;

    /* renamed from: h */
    private float f20247h;

    /* renamed from: i */
    private float f20248i;

    /* renamed from: j */
    private int f20249j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleOrientation {
    }

    BubbleLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20243d = new Path();
        this.f20244e = new Path();
        this.f20245f = null;
        this.f20249j = 32;
        m14884a(context, attributeSet);
    }

    public static float dip2Px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public void setBubbleParams(int i, float f) {
        this.f20249j = i;
        if (f > 0.0f) {
            f20242c = f;
        }
    }

    public void setFillColor(int i) {
        this.f20245f.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f20247h = (float) getMeasuredWidth();
        this.f20248i = (float) getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Matrix a = m14882a(this.f20247h, this.f20248i);
        this.f20243d.rewind();
        Path path = this.f20243d;
        RectF rectF = this.f20246g;
        float f = sCornerRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        this.f20243d.addPath(this.f20244e, a);
        canvas.drawPath(this.f20243d, this.f20245f);
    }

    /* renamed from: a */
    private void m14884a(Context context, AttributeSet attributeSet) {
        sDefaultPaddingH = (int) dip2Px(context, 0.0f);
        sDefaultPaddingV = (int) dip2Px(context, 0.0f);
        sStrokeWidth = 2.0f;
        sCornerRadius = dip2Px(context, 6.0f);
        f20240a = (int) dip2Px(context, 6.0f);
        f20241b = (int) dip2Px(context, 5.0f);
        Paint paint = new Paint();
        this.f20245f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f20245f.setStrokeCap(Paint.Cap.BUTT);
        this.f20245f.setAntiAlias(true);
        this.f20245f.setStrokeWidth(sStrokeWidth);
        this.f20245f.setStrokeJoin(Paint.Join.MITER);
        setLayerType(1, this.f20245f);
        m14883a();
        setBackgroundColor(0);
        setClipChildren(false);
    }

    /* renamed from: a */
    private void m14883a() {
        if (this.f20249j != 0) {
            this.f20244e.moveTo(0.0f, 0.0f);
            this.f20244e.lineTo((float) f20241b, (float) (-f20240a));
            this.f20244e.lineTo((float) f20241b, (float) f20240a);
            this.f20244e.close();
        }
    }

    /* renamed from: a */
    private Matrix m14882a(float f, float f2) {
        Matrix matrix = new Matrix();
        int i = this.f20249j;
        if (i == 1) {
            f *= f20242c;
            matrix.postRotate(90.0f);
            int i2 = sDefaultPaddingH;
            int i3 = f20241b;
            int i4 = sDefaultPaddingV;
            setPadding(i2, i3 + i4, 0, i4);
            this.f20246g = new RectF(0.0f, (float) f20241b, this.f20247h, this.f20248i);
        } else if (i == 2) {
            f *= 0.5f;
            matrix.postRotate(90.0f);
            int i5 = sDefaultPaddingH;
            int i6 = f20241b;
            int i7 = sDefaultPaddingV;
            setPadding(i5, i6 + i7, 0, i7);
            this.f20246g = new RectF(0.0f, (float) f20241b, this.f20247h, this.f20248i);
        } else if (i != 3) {
            if (i == 16) {
                f2 *= f20242c;
                int i8 = sDefaultPaddingH + f20241b;
                int i9 = sDefaultPaddingV;
                setPadding(i8, i9, 0, i9);
                this.f20246g = new RectF((float) f20241b, 0.0f, this.f20247h, this.f20248i);
            } else if (i == 32) {
                f2 *= 0.5f;
                int i10 = sDefaultPaddingH + f20241b;
                int i11 = sDefaultPaddingV;
                setPadding(i10, i11, 0, i11);
                this.f20246g = new RectF((float) f20241b, 0.0f, this.f20247h, this.f20248i);
            } else if (i != 48) {
                if (i == 256) {
                    f2 *= f20242c;
                    matrix.postRotate(180.0f);
                    int i12 = sDefaultPaddingH;
                    int i13 = sDefaultPaddingV;
                    setPadding(i12, i13, f20241b, i13);
                    this.f20246g = new RectF(0.0f, 0.0f, this.f20247h - ((float) f20241b), this.f20248i);
                } else if (i == 512) {
                    f2 *= 0.5f;
                    matrix.postRotate(180.0f);
                    int i14 = sDefaultPaddingH;
                    int i15 = sDefaultPaddingV;
                    setPadding(i14, i15, f20241b, i15);
                    this.f20246g = new RectF(0.0f, 0.0f, this.f20247h - ((float) f20241b), this.f20248i);
                } else if (i == 768) {
                    f2 *= 1.0f - f20242c;
                    matrix.postRotate(180.0f);
                    int i16 = sDefaultPaddingH;
                    int i17 = sDefaultPaddingV;
                    setPadding(i16, i17, f20241b, i17);
                    this.f20246g = new RectF(0.0f, 0.0f, this.f20247h - ((float) f20241b), this.f20248i);
                } else if (i == 4096) {
                    f *= f20242c;
                    matrix.postRotate(270.0f);
                    int i18 = sDefaultPaddingH;
                    int i19 = sDefaultPaddingV;
                    setPadding(i18, i19, 0, f20241b + i19);
                    this.f20246g = new RectF(0.0f, 0.0f, this.f20247h, this.f20248i - ((float) f20241b));
                } else if (i == 8192) {
                    f *= 0.5f;
                    matrix.postRotate(270.0f);
                    int i20 = sDefaultPaddingH;
                    int i21 = sDefaultPaddingV;
                    setPadding(i20, i21, 0, f20241b + i21);
                    this.f20246g = new RectF(0.0f, 0.0f, this.f20247h, this.f20248i - ((float) f20241b));
                } else if (i != 12288) {
                    this.f20246g = new RectF(0.0f, 0.0f, this.f20247h, this.f20248i);
                    f = 0.0f;
                } else {
                    f *= 1.0f - f20242c;
                    matrix.postRotate(270.0f);
                    int i22 = sDefaultPaddingH;
                    int i23 = sDefaultPaddingV;
                    setPadding(i22, i23, 0, f20241b + i23);
                    this.f20246g = new RectF(0.0f, 0.0f, this.f20247h, this.f20248i - ((float) f20241b));
                }
                matrix.postTranslate(f, f2);
                return matrix;
            } else {
                f2 *= 1.0f - f20242c;
                int i24 = sDefaultPaddingH + f20241b;
                int i25 = sDefaultPaddingV;
                setPadding(i24, i25, 0, i25);
                this.f20246g = new RectF((float) f20241b, 0.0f, this.f20247h, this.f20248i);
            }
            f = 0.0f;
            matrix.postTranslate(f, f2);
            return matrix;
        } else {
            f *= 1.0f - f20242c;
            matrix.postRotate(90.0f);
            int i26 = sDefaultPaddingH;
            int i27 = f20241b;
            int i28 = sDefaultPaddingV;
            setPadding(i26, i27 + i28, 0, i28);
            this.f20246g = new RectF(0.0f, (float) f20241b, this.f20247h, this.f20248i);
        }
        f2 = 0.0f;
        matrix.postTranslate(f, f2);
        return matrix;
    }
}
