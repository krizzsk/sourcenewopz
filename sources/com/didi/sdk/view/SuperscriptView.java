package com.didi.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.didi.passenger.C10448R;

public class SuperscriptView extends TextView {
    public static final int Gravity_LEFT_TOP = 1;
    public static final int Gravity_RIGHT_TOP = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public float f37901a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f37902b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f37903c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f37904d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f37905e;

    /* renamed from: f */
    private int f37906f;

    /* renamed from: g */
    private Animation f37907g = new Animation() {
        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            if (SuperscriptView.this.f37904d >= 1 && SuperscriptView.this.f37905e >= 1) {
                Matrix matrix = transformation.getMatrix();
                matrix.setTranslate(SuperscriptView.this.f37901a, SuperscriptView.this.f37902b);
                matrix.postRotate(SuperscriptView.this.f37903c, SuperscriptView.this.f37901a, SuperscriptView.this.f37902b);
            }
        }
    };

    public SuperscriptView(Context context) {
        super(context);
    }

    public SuperscriptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26826a(context, attributeSet);
    }

    public SuperscriptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26826a(context, attributeSet);
    }

    public void setVisibility(int i) {
        clearAnimation();
        super.setVisibility(i);
        if (i == 0) {
            startAnimation(this.f37907g);
        }
    }

    /* renamed from: a */
    private void m26826a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SuperscriptView);
        this.f37906f = obtainStyledAttributes.getInt(0, 1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        int i = this.f37906f;
        if (i == 1) {
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            if (dimensionPixelSize4 <= 0 || dimensionPixelSize2 <= 0) {
                m26828b(dimensionPixelSize3, dimensionPixelSize);
            } else {
                m26829b(dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize, dimensionPixelSize2);
            }
        } else if (i == 2) {
            int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            if (dimensionPixelSize6 <= 0 || dimensionPixelSize2 <= 0) {
                m26824a(dimensionPixelSize5, dimensionPixelSize);
            } else {
                m26825a(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize, dimensionPixelSize2);
            }
        }
        obtainStyledAttributes.recycle();
        this.f37907g.setFillBefore(true);
        this.f37907g.setFillAfter(true);
        this.f37907g.setFillEnabled(true);
        startAnimation(this.f37907g);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = this.f37904d;
        if (i4 < 1 || (i3 = this.f37905e) < 1) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (super.getVisibility() == 0) {
            startAnimation(this.f37907g);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        super.clearAnimation();
    }

    /* renamed from: a */
    private void m26824a(int i, int i2) {
        double d = (double) i2;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        this.f37903c = (float) Math.toDegrees(Math.asin(d3));
        int round = Math.round((float) (d3 * d));
        this.f37904d = round;
        this.f37902b = -((float) ((d / sqrt) * ((double) round)));
        this.f37901a = (float) ((d3 * ((double) round)) + (sqrt - d));
        this.f37905e = Math.round((float) sqrt);
    }

    /* renamed from: a */
    private void m26825a(int i, int i2, int i3, int i4) {
        double d = (double) i3;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        double d4 = (d - ((double) i4)) * d3;
        this.f37902b = (float) (-((d / sqrt) * d4));
        this.f37901a = (float) ((sqrt - d) + (d3 * d4));
        this.f37903c = (float) Math.toDegrees(Math.asin(d3));
        this.f37905e = Math.round((float) sqrt);
        this.f37904d = Math.round((float) d4);
    }

    /* renamed from: b */
    private void m26828b(int i, int i2) {
        double d = (double) i2;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        this.f37903c = -((float) Math.toDegrees(Math.asin(d3)));
        this.f37904d = Math.round((float) (d3 * d));
        double d4 = d2 * d3;
        this.f37901a = -((float) ((d / sqrt) * d4));
        this.f37902b = (float) (d3 * d4);
        this.f37905e = Math.round((float) sqrt);
    }

    /* renamed from: b */
    private void m26829b(int i, int i2, int i3, int i4) {
        double d = (double) i3;
        double d2 = (double) i;
        double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
        double d3 = d2 / sqrt;
        this.f37903c = -((float) Math.toDegrees(Math.asin(d3)));
        this.f37904d = Math.round((float) (((double) (i3 - i4)) * d3));
        double d4 = ((double) (i - i2)) * d3;
        this.f37901a = -((float) ((d / sqrt) * d4));
        this.f37902b = (float) (((double) i2) + (d3 * d4));
        this.f37905e = Math.round((float) sqrt);
    }
}
