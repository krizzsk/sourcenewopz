package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a */
    private final List<Keyframe<PointF>> f1389a;

    public AnimatablePathValue() {
        this.f1389a = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f1389a = list;
    }

    public List<Keyframe<PointF>> getKeyframes() {
        return this.f1389a;
    }

    public boolean isStatic() {
        return this.f1389a.size() == 1 && this.f1389a.get(0).isStatic();
    }

    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        if (this.f1389a.get(0).isStatic()) {
            return new PointKeyframeAnimation(this.f1389a);
        }
        return new PathKeyframeAnimation(this.f1389a);
    }
}
