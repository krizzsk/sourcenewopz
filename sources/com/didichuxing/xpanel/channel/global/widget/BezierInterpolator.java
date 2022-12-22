package com.didichuxing.xpanel.channel.global.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

public class BezierInterpolator implements Interpolator {

    /* renamed from: a */
    private static final int f49395a = 4096;

    /* renamed from: b */
    private int f49396b = 0;

    /* renamed from: c */
    private final PointF f49397c = new PointF();

    /* renamed from: d */
    private final PointF f49398d = new PointF();

    public static double cubicCurves(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0d - d;
        double d7 = d * d;
        double d8 = d6 * d6;
        return (d8 * d6 * d2) + (d8 * 3.0d * d * d3) + (d6 * 3.0d * d7 * d4) + (d7 * d * d5);
    }

    public BezierInterpolator(float f, float f2, float f3, float f4) {
        this.f49397c.x = f;
        this.f49397c.y = f2;
        this.f49398d.x = f3;
        this.f49398d.y = f4;
    }

    public float getInterpolation(float f) {
        this.f49396b = 0;
        float f2 = f;
        int i = 0;
        while (true) {
            if (i >= 4096) {
                break;
            }
            f2 = (((float) i) * 1.0f) / 4096.0f;
            if (cubicCurves((double) f2, 0.0d, (double) this.f49397c.x, (double) this.f49398d.x, 1.0d) >= ((double) f)) {
                this.f49396b = i;
                break;
            }
            i++;
        }
        double cubicCurves = cubicCurves((double) f2, 0.0d, (double) this.f49397c.y, (double) this.f49398d.y, 1.0d);
        if (cubicCurves > 0.999d) {
            cubicCurves = 1.0d;
            this.f49396b = 0;
        }
        return (float) cubicCurves;
    }
}
