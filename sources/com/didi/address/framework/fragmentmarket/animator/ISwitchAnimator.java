package com.didi.address.framework.fragmentmarket.animator;

import android.animation.Animator;

public interface ISwitchAnimator {

    /* renamed from: com.didi.address.framework.fragmentmarket.animator.ISwitchAnimator$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Animator $default$getSecondaryPageEnterAnimator(ISwitchAnimator iSwitchAnimator) {
            return null;
        }

        public static Animator $default$getSecondaryPageExitAnimator(ISwitchAnimator iSwitchAnimator) {
            return null;
        }
    }

    Animator getEnterAnimator();

    Animator getExitAnimator();

    Animator getSecondaryPageEnterAnimator();

    Animator getSecondaryPageExitAnimator();
}
