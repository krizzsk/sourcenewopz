package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;
import java.util.ArrayList;

public class AnimationSet extends Animation {

    /* renamed from: a */
    private ArrayList<Animation> f10907a = new ArrayList<>();

    /* renamed from: b */
    private boolean f10908b;

    public AnimationSet(boolean z) {
        this.mType = Animation.AnimationType.SET;
        this.f10908b = z;
    }

    public boolean addAnimation(Animation animation) {
        if (animation == null) {
            return false;
        }
        synchronized (this) {
            this.f10907a.add(animation);
        }
        return true;
    }

    public void cleanAnimation() {
        synchronized (this) {
            this.f10907a.clear();
        }
    }

    public ArrayList<Animation> getAllAnimations() {
        return this.f10907a;
    }

    public boolean getShareInterpolator() {
        return this.f10908b;
    }
}
