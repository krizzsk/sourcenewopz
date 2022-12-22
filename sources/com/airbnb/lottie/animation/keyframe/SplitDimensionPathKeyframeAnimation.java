package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* renamed from: b */
    private final PointF f1338b = new PointF();

    /* renamed from: c */
    private final BaseKeyframeAnimation<Float, Float> f1339c;

    /* renamed from: d */
    private final BaseKeyframeAnimation<Float, Float> f1340d;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.f1339c = baseKeyframeAnimation;
        this.f1340d = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    public void setProgress(float f) {
        this.f1339c.setProgress(f);
        this.f1340d.setProgress(f);
        this.f1338b.set(this.f1339c.getValue().floatValue(), this.f1340d.getValue().floatValue());
        for (int i = 0; i < this.f1318a.size(); i++) {
            ((BaseKeyframeAnimation.AnimationListener) this.f1318a.get(i)).onValueChanged();
        }
    }

    public PointF getValue() {
        return getValue((Keyframe<PointF>) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        return this.f1338b;
    }
}
