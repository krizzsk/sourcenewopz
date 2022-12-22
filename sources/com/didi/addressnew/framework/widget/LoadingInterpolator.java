package com.didi.addressnew.framework.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class LoadingInterpolator implements Interpolator {

    /* renamed from: a */
    protected PointF f7425a;

    /* renamed from: b */
    protected PointF f7426b;

    /* renamed from: c */
    protected PointF f7427c;
    protected PointF end;
    protected PointF start;

    public LoadingInterpolator(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.f7425a = new PointF();
        this.f7426b = new PointF();
        this.f7427c = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        } else if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        } else {
            this.start = pointF;
            this.end = pointF2;
        }
    }

    public LoadingInterpolator(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    public LoadingInterpolator(double d, double d2, double d3, double d4) {
        this((float) d, (float) d2, (float) d3, (float) d4);
    }

    public float getInterpolation(float f) {
        return getBezierCoordinateY(getXForTime(f));
    }

    /* access modifiers changed from: protected */
    public float getBezierCoordinateY(float f) {
        this.f7427c.y = this.start.y * 3.0f;
        this.f7426b.y = ((this.end.y - this.start.y) * 3.0f) - this.f7427c.y;
        this.f7425a.y = (1.0f - this.f7427c.y) - this.f7426b.y;
        return f * (this.f7427c.y + ((this.f7426b.y + (this.f7425a.y * f)) * f));
    }

    /* access modifiers changed from: protected */
    public float getXForTime(float f) {
        float f2 = f;
        for (int i = 1; i < 14; i++) {
            float b = m4671b(f2) - f;
            if (((double) Math.abs(b)) < 0.001d) {
                break;
            }
            f2 -= b / m4670a(f2);
        }
        return f2;
    }

    /* renamed from: a */
    private float m4670a(float f) {
        return this.f7427c.x + (f * ((this.f7426b.x * 2.0f) + (this.f7425a.x * 3.0f * f)));
    }

    /* renamed from: b */
    private float m4671b(float f) {
        this.f7427c.x = this.start.x * 3.0f;
        this.f7426b.x = ((this.end.x - this.start.x) * 3.0f) - this.f7427c.x;
        this.f7425a.x = (1.0f - this.f7427c.x) - this.f7426b.x;
        return f * (this.f7427c.x + ((this.f7426b.x + (this.f7425a.x * f)) * f));
    }
}
