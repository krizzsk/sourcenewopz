package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: com.airbnb.lottie.value.a */
/* compiled from: LottieInterpolatedValue */
abstract class C1526a<T> extends LottieValueCallback<T> {

    /* renamed from: a */
    private final T f1721a;

    /* renamed from: b */
    private final T f1722b;

    /* renamed from: c */
    private final Interpolator f1723c;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract T mo15591a(T t, T t2, float f);

    C1526a(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    C1526a(T t, T t2, Interpolator interpolator) {
        this.f1721a = t;
        this.f1722b = t2;
        this.f1723c = interpolator;
    }

    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return mo15591a(this.f1721a, this.f1722b, this.f1723c.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }
}
