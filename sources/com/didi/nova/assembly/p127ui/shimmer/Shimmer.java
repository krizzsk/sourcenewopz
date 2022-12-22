package com.didi.nova.assembly.p127ui.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.didi.nova.assembly.p127ui.shimmer.ShimmerViewHelper;

/* renamed from: com.didi.nova.assembly.ui.shimmer.Shimmer */
public class Shimmer {
    public static final int ANIMATION_DIRECTION_LTR = 0;
    public static final int ANIMATION_DIRECTION_RTL = 1;

    /* renamed from: a */
    private static final int f29297a = -1;

    /* renamed from: b */
    private static final long f29298b = 1000;

    /* renamed from: c */
    private static final long f29299c = 0;

    /* renamed from: d */
    private static final int f29300d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f29301e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f29302f = 1000;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f29303g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f29304h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Animator.AnimatorListener f29305i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ObjectAnimator f29306j;

    public int getRepeatCount() {
        return this.f29301e;
    }

    public Shimmer setRepeatCount(int i) {
        this.f29301e = i;
        return this;
    }

    public long getDuration() {
        return this.f29302f;
    }

    public Shimmer setDuration(long j) {
        this.f29302f = j;
        return this;
    }

    public long getStartDelay() {
        return this.f29303g;
    }

    public Shimmer setStartDelay(long j) {
        this.f29303g = j;
        return this;
    }

    public int getDirection() {
        return this.f29304h;
    }

    public Shimmer setDirection(int i) {
        if (i == 0 || i == 1) {
            this.f29304h = i;
            return this;
        }
        throw new IllegalArgumentException("The animation direction must be either ANIMATION_DIRECTION_LTR or ANIMATION_DIRECTION_RTL");
    }

    public Animator.AnimatorListener getAnimatorListener() {
        return this.f29305i;
    }

    public Shimmer setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f29305i = animatorListener;
        return this;
    }

    public <V extends View & ShimmerViewBase> void start(final V v) {
        if (!isAnimating()) {
            final C102811 r0 = new Runnable() {
                public void run() {
                    ((ShimmerViewBase) v).setShimmering(true);
                    float width = (float) v.getWidth();
                    float f = 0.0f;
                    if (Shimmer.this.f29304h == 1) {
                        f = (float) v.getWidth();
                        width = 0.0f;
                    }
                    ObjectAnimator unused = Shimmer.this.f29306j = ObjectAnimator.ofFloat(v, "gradientX", new float[]{f, width});
                    Shimmer.this.f29306j.setRepeatCount(Shimmer.this.f29301e);
                    Shimmer.this.f29306j.setDuration(Shimmer.this.f29302f);
                    Shimmer.this.f29306j.setStartDelay(Shimmer.this.f29303g);
                    Shimmer.this.f29306j.addListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            ((ShimmerViewBase) v).setShimmering(false);
                            v.postInvalidateOnAnimation();
                            ObjectAnimator unused = Shimmer.this.f29306j = null;
                        }
                    });
                    if (Shimmer.this.f29305i != null) {
                        Shimmer.this.f29306j.addListener(Shimmer.this.f29305i);
                    }
                    Shimmer.this.f29306j.start();
                }
            };
            ShimmerViewBase shimmerViewBase = (ShimmerViewBase) v;
            if (!shimmerViewBase.isSetUp()) {
                shimmerViewBase.setAnimationSetupCallback(new ShimmerViewHelper.AnimationSetupCallback() {
                    public void onSetupAnimation(View view) {
                        r0.run();
                    }
                });
            } else {
                r0.run();
            }
        }
    }

    public void cancel() {
        ObjectAnimator objectAnimator = this.f29306j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public boolean isAnimating() {
        ObjectAnimator objectAnimator = this.f29306j;
        return objectAnimator != null && objectAnimator.isRunning();
    }
}
