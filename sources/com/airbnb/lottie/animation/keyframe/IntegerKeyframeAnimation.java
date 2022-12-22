package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class IntegerKeyframeAnimation extends C1482a<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Integer getValue(Keyframe<Integer> keyframe, float f) {
        return Integer.valueOf(mo15250b(keyframe, f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo15250b(Keyframe<Integer> keyframe, float f) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.valueCallback != null) {
            Integer num = (Integer) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, mo15224a(), getProgress());
            if (num != null) {
                return num.intValue();
            }
        }
        return MiscUtils.lerp(keyframe.getStartValueInt(), keyframe.getEndValueInt(), f);
    }

    public int getIntValue() {
        return mo15250b(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
