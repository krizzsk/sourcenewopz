package com.didi.common.map.model.animation;

import android.view.animation.Interpolator;

public abstract class Animation {
    protected long mDuration = 0;
    protected Interpolator mInterpolator;
    protected AnimationType mType = AnimationType.ALPHA;

    public enum AnimationType {
        SET,
        ALPHA,
        ROTATE,
        SCALE,
        TRANSLATE,
        EMERGE
    }

    public AnimationType getType() {
        return this.mType;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }
}
