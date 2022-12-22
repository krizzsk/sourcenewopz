package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapAnimation;

public abstract class Animation {
    public MapAnimation animation = null;
    private long delay;
    private long duration;
    private Interpolator interpolator;
    protected WrappedAnimationListener mAnimationListener;

    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public long getDuration() {
        return this.duration;
    }

    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setInterpolator(Interpolator interpolator2) {
        this.interpolator = interpolator2;
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        WrappedAnimationListener wrappedAnimationListener = new WrappedAnimationListener(animationListener);
        this.mAnimationListener = wrappedAnimationListener;
        MapAnimation mapAnimation = this.animation;
        if (mapAnimation != null) {
            mapAnimation.setAnimationListener(wrappedAnimationListener);
        }
    }

    public AnimationListener getListener() {
        WrappedAnimationListener wrappedAnimationListener = this.mAnimationListener;
        if (wrappedAnimationListener != null) {
            return wrappedAnimationListener.listener;
        }
        return null;
    }

    private static class WrappedAnimationListener implements MapAnimation.InnerAnimationListener {
        /* access modifiers changed from: private */
        public AnimationListener listener;

        public WrappedAnimationListener(AnimationListener animationListener) {
            this.listener = animationListener;
        }

        public void onAnimationStart() {
            AnimationListener animationListener = this.listener;
            if (animationListener != null) {
                animationListener.onAnimationStart();
            }
        }

        public void onAnimationFinish() {
            AnimationListener animationListener = this.listener;
            if (animationListener != null) {
                animationListener.onAnimationEnd();
            }
        }
    }
}
