package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation {

    /* renamed from: a */
    private final List<BaseKeyframeAnimation<ShapeData, Path>> f1325a;

    /* renamed from: b */
    private final List<BaseKeyframeAnimation<Integer, Integer>> f1326b;

    /* renamed from: c */
    private final List<Mask> f1327c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.f1327c = list;
        this.f1325a = new ArrayList(list.size());
        this.f1326b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f1325a.add(list.get(i).getMaskPath().createAnimation());
            this.f1326b.add(list.get(i).getOpacity().createAnimation());
        }
    }

    public List<Mask> getMasks() {
        return this.f1327c;
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> getMaskAnimations() {
        return this.f1325a;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> getOpacityAnimations() {
        return this.f1326b;
    }
}
