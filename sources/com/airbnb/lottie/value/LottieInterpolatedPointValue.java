package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedPointValue extends C1526a<PointF> {

    /* renamed from: a */
    private final PointF f1717a = new PointF();

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PointF mo15591a(PointF pointF, PointF pointF2, float f) {
        this.f1717a.set(MiscUtils.lerp(pointF.x, pointF2.x, f), MiscUtils.lerp(pointF.y, pointF2.y, f));
        return this.f1717a;
    }
}
