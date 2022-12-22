package com.didi.soda.customer.widget;

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
    private static int f41406a = 0;

    /* renamed from: b */
    private static int f41407b = 0;

    /* renamed from: c */
    private static float f41408c = 0.2f;
    public static float sCornerRadius;
    public static int sDefaultPaddingH;
    public static int sDefaultPaddingV;
    public static float sStrokeWidth;

    /* renamed from: d */
    private final Path f41409d;

    /* renamed from: e */
    private final Path f41410e;

    /* renamed from: f */
    private Paint f41411f;

    /* renamed from: g */
    private RectF f41412g;

    /* renamed from: h */
    private float f41413h;

    /* renamed from: i */
    private float f41414i;

    /* renamed from: j */
    private int f41415j;

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
        this.f41409d = new Path();
        this.f41410e = new Path();
        this.f41411f = null;
        this.f41415j = 32;
        m29323a(context, attributeSet);
    }

    public static float dip2Px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public void setBubbleParams(int i, float f) {
        this.f41415j = i;
        if (f > 0.0f) {
            f41408c = f;
        }
    }

    public void setFillColor(int i) {
        this.f41411f.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f41413h = (float) getMeasuredWidth();
        this.f41414i = (float) getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Matrix a = m29321a(this.f41413h, this.f41414i);
        this.f41409d.rewind();
        Path path = this.f41409d;
        RectF rectF = this.f41412g;
        float f = sCornerRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        this.f41409d.addPath(this.f41410e, a);
        canvas.drawPath(this.f41409d, this.f41411f);
    }

    /* renamed from: a */
    private void m29323a(Context context, AttributeSet attributeSet) {
        sDefaultPaddingH = (int) dip2Px(context, 0.0f);
        sDefaultPaddingV = (int) dip2Px(context, 0.0f);
        sStrokeWidth = 2.0f;
        sCornerRadius = dip2Px(context, 6.0f);
        f41406a = (int) dip2Px(context, 6.0f);
        f41407b = (int) dip2Px(context, 5.0f);
        Paint paint = new Paint();
        this.f41411f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f41411f.setStrokeCap(Paint.Cap.BUTT);
        this.f41411f.setAntiAlias(true);
        this.f41411f.setStrokeWidth(sStrokeWidth);
        this.f41411f.setStrokeJoin(Paint.Join.MITER);
        setLayerType(1, this.f41411f);
        m29322a();
        setBackgroundColor(0);
        setClipChildren(false);
    }

    /* renamed from: a */
    private void m29322a() {
        if (this.f41415j != 0) {
            this.f41410e.moveTo(0.0f, 0.0f);
            this.f41410e.lineTo((float) f41407b, (float) (-f41406a));
            this.f41410e.lineTo((float) f41407b, (float) f41406a);
            this.f41410e.close();
        }
    }

    /* renamed from: a */
    private Matrix m29321a(float f, float f2) {
        Matrix matrix = new Matrix();
        int i = this.f41415j;
        if (i == 1) {
            f *= f41408c;
            matrix.postRotate(90.0f);
            int i2 = sDefaultPaddingH;
            int i3 = f41407b;
            int i4 = sDefaultPaddingV;
            setPadding(i2, i3 + i4, 0, i4);
            this.f41412g = new RectF(0.0f, (float) f41407b, this.f41413h, this.f41414i);
        } else if (i == 2) {
            f *= 0.5f;
            matrix.postRotate(90.0f);
            int i5 = sDefaultPaddingH;
            int i6 = f41407b;
            int i7 = sDefaultPaddingV;
            setPadding(i5, i6 + i7, 0, i7);
            this.f41412g = new RectF(0.0f, (float) f41407b, this.f41413h, this.f41414i);
        } else if (i != 3) {
            if (i == 16) {
                f2 *= f41408c;
                int i8 = sDefaultPaddingH + f41407b;
                int i9 = sDefaultPaddingV;
                setPadding(i8, i9, 0, i9);
                this.f41412g = new RectF((float) f41407b, 0.0f, this.f41413h, this.f41414i);
            } else if (i == 32) {
                f2 *= 0.5f;
                int i10 = sDefaultPaddingH + f41407b;
                int i11 = sDefaultPaddingV;
                setPadding(i10, i11, 0, i11);
                this.f41412g = new RectF((float) f41407b, 0.0f, this.f41413h, this.f41414i);
            } else if (i != 48) {
                if (i == 256) {
                    f2 *= f41408c;
                    matrix.postRotate(180.0f);
                    int i12 = sDefaultPaddingH;
                    int i13 = sDefaultPaddingV;
                    setPadding(i12, i13, f41407b, i13);
                    this.f41412g = new RectF(0.0f, 0.0f, this.f41413h - ((float) f41407b), this.f41414i);
                } else if (i == 512) {
                    f2 *= 0.5f;
                    matrix.postRotate(180.0f);
                    int i14 = sDefaultPaddingH;
                    int i15 = sDefaultPaddingV;
                    setPadding(i14, i15, f41407b, i15);
                    this.f41412g = new RectF(0.0f, 0.0f, this.f41413h - ((float) f41407b), this.f41414i);
                } else if (i == 768) {
                    f2 *= 1.0f - f41408c;
                    matrix.postRotate(180.0f);
                    int i16 = sDefaultPaddingH;
                    int i17 = sDefaultPaddingV;
                    setPadding(i16, i17, f41407b, i17);
                    this.f41412g = new RectF(0.0f, 0.0f, this.f41413h - ((float) f41407b), this.f41414i);
                } else if (i == 4096) {
                    f *= f41408c;
                    matrix.postRotate(270.0f);
                    int i18 = sDefaultPaddingH;
                    int i19 = sDefaultPaddingV;
                    setPadding(i18, i19, 0, f41407b + i19);
                    this.f41412g = new RectF(0.0f, 0.0f, this.f41413h, this.f41414i - ((float) f41407b));
                } else if (i == 8192) {
                    f *= 0.5f;
                    matrix.postRotate(270.0f);
                    int i20 = sDefaultPaddingH;
                    int i21 = sDefaultPaddingV;
                    setPadding(i20, i21, 0, f41407b + i21);
                    this.f41412g = new RectF(0.0f, 0.0f, this.f41413h, this.f41414i - ((float) f41407b));
                } else if (i != 12288) {
                    this.f41412g = new RectF(0.0f, 0.0f, this.f41413h, this.f41414i);
                    f = 0.0f;
                } else {
                    f *= 1.0f - f41408c;
                    matrix.postRotate(270.0f);
                    int i22 = sDefaultPaddingH;
                    int i23 = sDefaultPaddingV;
                    setPadding(i22, i23, 0, f41407b + i23);
                    this.f41412g = new RectF(0.0f, 0.0f, this.f41413h, this.f41414i - ((float) f41407b));
                }
                matrix.postTranslate(f, f2);
                return matrix;
            } else {
                f2 *= 1.0f - f41408c;
                int i24 = sDefaultPaddingH + f41407b;
                int i25 = sDefaultPaddingV;
                setPadding(i24, i25, 0, i25);
                this.f41412g = new RectF((float) f41407b, 0.0f, this.f41413h, this.f41414i);
            }
            f = 0.0f;
            matrix.postTranslate(f, f2);
            return matrix;
        } else {
            f *= 1.0f - f41408c;
            matrix.postRotate(90.0f);
            int i26 = sDefaultPaddingH;
            int i27 = f41407b;
            int i28 = sDefaultPaddingV;
            setPadding(i26, i27 + i28, 0, i28);
            this.f41412g = new RectF(0.0f, (float) f41407b, this.f41413h, this.f41414i);
        }
        f2 = 0.0f;
        matrix.postTranslate(f, f2);
        return matrix;
    }
}
