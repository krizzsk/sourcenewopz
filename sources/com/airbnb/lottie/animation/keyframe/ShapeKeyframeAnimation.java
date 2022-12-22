package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: b */
    private final ShapeData f1336b = new ShapeData();

    /* renamed from: c */
    private final Path f1337c = new Path();

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    public Path getValue(Keyframe<ShapeData> keyframe, float f) {
        this.f1336b.interpolateBetween((ShapeData) keyframe.startValue, (ShapeData) keyframe.endValue, f);
        MiscUtils.getPathFromData(this.f1336b, this.f1337c);
        return this.f1337c;
    }
}
