package com.didi.map.base.bubble;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnimationSetting {
    public static final int ALPHA = 0;
    public static final int Decelerate = 1;
    public static final int FastOutSlow = 2;
    public static final int Linear = 0;
    public static final int LinearOutSlow = 3;
    public static final int SCALE = 1;
    public long duration;
    public int interpolatorType;
    public boolean needAnimation;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimateType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InterpolatorType {
    }

    public AnimationSetting(int i, long j, int i2) {
        this.needAnimation = false;
        this.type = 0;
        this.interpolatorType = 0;
        this.duration = 500;
        this.needAnimation = true;
        this.type = i;
        this.duration = j;
        this.interpolatorType = i2;
    }
}
