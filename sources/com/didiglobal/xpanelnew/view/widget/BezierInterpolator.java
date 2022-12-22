package com.didiglobal.xpanelnew.view.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class BezierInterpolator implements Interpolator {

    /* renamed from: a */
    private static final int f51685a = 4096;

    /* renamed from: b */
    private int f51686b = 0;

    /* renamed from: c */
    private final PointF f51687c = new PointF();

    /* renamed from: d */
    private final PointF f51688d = new PointF();

    public static double cubicCurves(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0d - d;
        double d7 = d * d;
        double d8 = d6 * d6;
        return (d8 * d6 * d2) + (d8 * 3.0d * d * d3) + (d6 * 3.0d * d7 * d4) + (d7 * d * d5);
    }

    public BezierInterpolator(float f, float f2, float f3, float f4) {
        this.f51687c.x = f;
        this.f51687c.y = f2;
        this.f51688d.x = f3;
        this.f51688d.y = f4;
    }

    public float getInterpolation(float f) {
        this.f51686b = 0;
        float f2 = f;
        int i = 0;
        while (true) {
            if (i >= 4096) {
                break;
            }
            f2 = (((float) i) * 1.0f) / 4096.0f;
            if (cubicCurves((double) f2, 0.0d, (double) this.f51687c.x, (double) this.f51688d.x, 1.0d) >= ((double) f)) {
                this.f51686b = i;
                break;
            }
            i++;
        }
        double cubicCurves = cubicCurves((double) f2, 0.0d, (double) this.f51687c.y, (double) this.f51688d.y, 1.0d);
        if (cubicCurves > 0.999d) {
            cubicCurves = 1.0d;
            this.f51686b = 0;
        }
        return (float) cubicCurves;
    }
}
