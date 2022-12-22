package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation extends C1482a<ScaleXY> {

    /* renamed from: b */
    private final ScaleXY f1335b = new ScaleXY();

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY = (ScaleXY) keyframe.startValue;
        ScaleXY scaleXY2 = (ScaleXY) keyframe.endValue;
        if (this.valueCallback != null) {
            ScaleXY scaleXY3 = (ScaleXY) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY, scaleXY2, f, mo15224a(), getProgress());
            if (scaleXY3 != null) {
                return scaleXY3;
            }
        }
        this.f1335b.set(MiscUtils.lerp(scaleXY.getScaleX(), scaleXY2.getScaleX(), f), MiscUtils.lerp(scaleXY.getScaleY(), scaleXY2.getScaleY(), f));
        return this.f1335b;
    }
}
