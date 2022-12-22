package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapEmergeAnimation;
import com.didi.map.outer.model.LatLng;

public class EmergeAnimation extends Animation {

    /* renamed from: a */
    private LatLng f28068a = null;

    public EmergeAnimation(LatLng latLng) {
        if (this.animation == null) {
            this.animation = new MapEmergeAnimation(latLng);
        }
        this.f28068a = latLng;
    }

    public void setDuration(long j) {
        super.setDuration(j);
        if (this.animation != null) {
            this.animation.setDuration(j);
        }
    }

    public void setDelay(long j) {
        super.setDelay(j);
        if (this.animation != null) {
            this.animation.setDelay(j);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        if (this.animation != null && interpolator != null) {
            this.animation.setInterpolator(interpolator);
        }
    }

    public LatLng getStartPoint() {
        return this.f28068a;
    }
}
