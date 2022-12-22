package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {

    /* renamed from: a */
    private final PointF f1718a = new PointF();

    public LottieRelativePointValueCallback() {
    }

    public LottieRelativePointValueCallback(PointF pointF) {
        super(pointF);
    }

    public final PointF getValue(LottieFrameInfo<PointF> lottieFrameInfo) {
        this.f1718a.set(MiscUtils.lerp(lottieFrameInfo.getStartValue().x, lottieFrameInfo.getEndValue().x, lottieFrameInfo.getInterpolatedKeyframeProgress()), MiscUtils.lerp(lottieFrameInfo.getStartValue().y, lottieFrameInfo.getEndValue().y, lottieFrameInfo.getInterpolatedKeyframeProgress()));
        PointF offset = getOffset(lottieFrameInfo);
        this.f1718a.offset(offset.x, offset.y);
        return this.f1718a;
    }

    public PointF getOffset(LottieFrameInfo<PointF> lottieFrameInfo) {
        if (this.value != null) {
            return (PointF) this.value;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
