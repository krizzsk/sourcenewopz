package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class FloatKeyframeAnimation extends C1482a<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Float getValue(Keyframe<Float> keyframe, float f) {
        return Float.valueOf(mo15246b(keyframe, f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo15246b(Keyframe<Float> keyframe, float f) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.valueCallback != null) {
            Float f2 = (Float) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, mo15224a(), getProgress());
            if (f2 != null) {
                return f2.floatValue();
            }
        }
        return MiscUtils.lerp(keyframe.getStartValueFloat(), keyframe.getEndValueFloat(), f);
    }

    public float getFloatValue() {
        return mo15246b(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
