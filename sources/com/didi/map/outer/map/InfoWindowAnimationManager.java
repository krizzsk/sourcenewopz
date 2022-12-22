package com.didi.map.outer.map;

import com.didi.map.outer.model.animation.Animation;

public class InfoWindowAnimationManager {

    /* renamed from: a */
    private SetInfoWindowAnimate f27848a = null;

    public interface SetInfoWindowAnimate {
        void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener);

        void setInfoWindowAppearAnimate(Animation animation);

        void setInfoWindowDisAppearAnimate(Animation animation);

        void setInfoWindowMovingAnimate(Animation animation);

        void setInfowindowBackColor(int i);

        void setInfowindowBackEnable(boolean z);

        void setInfowindowBackSacle(float f, float f2);

        void startAnimation();
    }

    public InfoWindowAnimationManager(SetInfoWindowAnimate setInfoWindowAnimate) {
        this.f27848a = setInfoWindowAnimate;
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.setInfoWindowAppearAnimate(animation);
        }
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.setInfoWindowMovingAnimate(animation);
        }
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.setInfoWindowDisAppearAnimate(animation);
        }
    }

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.setInfoWindowAnimation(animation, animationListener);
        }
    }

    public void startAnimation() {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.startAnimation();
        }
    }

    public void setInfowindowBackColor(int i) {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.setInfowindowBackColor(i);
        }
    }

    public void setInfowindowBackEnable(boolean z) {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.setInfowindowBackEnable(z);
        }
    }

    public void setInfowindowBackSacle(float f, float f2) {
        SetInfoWindowAnimate setInfoWindowAnimate = this.f27848a;
        if (setInfoWindowAnimate != null) {
            setInfoWindowAnimate.setInfowindowBackSacle(f, f2);
        }
    }
}
