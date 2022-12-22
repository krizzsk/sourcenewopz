package com.didi.common.map.model.animation;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.animation.Animation;

public class TranslateAnimation extends Animation {

    /* renamed from: a */
    private LatLng f10919a;

    public TranslateAnimation(LatLng latLng) {
        this.mType = Animation.AnimationType.TRANSLATE;
        this.f10919a = latLng;
    }

    public LatLng getTarget() {
        return this.f10919a;
    }
}
