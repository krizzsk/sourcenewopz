package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation extends C1482a<GradientColor> {

    /* renamed from: b */
    private final GradientColor f1324b;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int i = 0;
        GradientColor gradientColor = (GradientColor) list.get(0).startValue;
        i = gradientColor != null ? gradientColor.getSize() : i;
        this.f1324b = new GradientColor(new float[i], new int[i]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float f) {
        this.f1324b.lerp((GradientColor) keyframe.startValue, (GradientColor) keyframe.endValue, f);
        return this.f1324b;
    }
}
