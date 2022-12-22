package com.didi.common.map.model.animation;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.animation.Animation;

public class EmergeAnimation extends Animation {

    /* renamed from: a */
    private LatLng f10909a = null;

    public EmergeAnimation(LatLng latLng) {
        this.mType = Animation.AnimationType.EMERGE;
        this.f10909a = latLng;
    }

    public LatLng getStartPoint() {
        return this.f10909a;
    }
}
