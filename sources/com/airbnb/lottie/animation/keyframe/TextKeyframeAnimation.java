package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class TextKeyframeAnimation extends C1482a<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public DocumentData getValue(Keyframe<DocumentData> keyframe, float f) {
        return (DocumentData) keyframe.startValue;
    }
}
