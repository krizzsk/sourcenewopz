package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

public class Keyframe<T> {

    /* renamed from: a */
    private static final float f1701a = -3987645.8f;

    /* renamed from: b */
    private static final int f1702b = 784923401;

    /* renamed from: c */
    private final LottieComposition f1703c;

    /* renamed from: d */
    private float f1704d;

    /* renamed from: e */
    private float f1705e;
    public Float endFrame;
    public T endValue;

    /* renamed from: f */
    private int f1706f;

    /* renamed from: g */
    private int f1707g;

    /* renamed from: h */
    private float f1708h;

    /* renamed from: i */
    private float f1709i;
    public final Interpolator interpolator;
    public PointF pathCp1;
    public PointF pathCp2;
    public final float startFrame;
    public final T startValue;

    public Keyframe(LottieComposition lottieComposition, T t, T t2, Interpolator interpolator2, float f, Float f2) {
        this.f1704d = f1701a;
        this.f1705e = f1701a;
        this.f1706f = f1702b;
        this.f1707g = f1702b;
        this.f1708h = Float.MIN_VALUE;
        this.f1709i = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.f1703c = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator2;
        this.startFrame = f;
        this.endFrame = f2;
    }

    public Keyframe(T t) {
        this.f1704d = f1701a;
        this.f1705e = f1701a;
        this.f1706f = f1702b;
        this.f1707g = f1702b;
        this.f1708h = Float.MIN_VALUE;
        this.f1709i = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.f1703c = null;
        this.startValue = t;
        this.endValue = t;
        this.interpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = Float.valueOf(Float.MAX_VALUE);
    }

    public float getStartProgress() {
        LottieComposition lottieComposition = this.f1703c;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f1708h == Float.MIN_VALUE) {
            this.f1708h = (this.startFrame - lottieComposition.getStartFrame()) / this.f1703c.getDurationFrames();
        }
        return this.f1708h;
    }

    public float getEndProgress() {
        if (this.f1703c == null) {
            return 1.0f;
        }
        if (this.f1709i == Float.MIN_VALUE) {
            if (this.endFrame == null) {
                this.f1709i = 1.0f;
            } else {
                this.f1709i = getStartProgress() + ((this.endFrame.floatValue() - this.startFrame) / this.f1703c.getDurationFrames());
            }
        }
        return this.f1709i;
    }

    public boolean isStatic() {
        return this.interpolator == null;
    }

    public boolean containsProgress(float f) {
        return f >= getStartProgress() && f < getEndProgress();
    }

    public float getStartValueFloat() {
        if (this.f1704d == f1701a) {
            this.f1704d = ((Float) this.startValue).floatValue();
        }
        return this.f1704d;
    }

    public float getEndValueFloat() {
        if (this.f1705e == f1701a) {
            this.f1705e = ((Float) this.endValue).floatValue();
        }
        return this.f1705e;
    }

    public int getStartValueInt() {
        if (this.f1706f == f1702b) {
            this.f1706f = ((Integer) this.startValue).intValue();
        }
        return this.f1706f;
    }

    public int getEndValueInt() {
        if (this.f1707g == f1702b) {
            this.f1707g = ((Integer) this.endValue).intValue();
        }
        return this.f1707g;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.startValue + ", endValue=" + this.endValue + ", startFrame=" + this.startFrame + ", endFrame=" + this.endFrame + ", interpolator=" + this.interpolator + '}';
    }
}
