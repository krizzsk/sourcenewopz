package com.didi.map.global.flow.scene.sug;

import android.animation.Animator;

public interface ISugTransferAnimator {

    /* renamed from: com.didi.map.global.flow.scene.sug.ISugTransferAnimator$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Animator $default$getSecondaryPageEnterAnimator(ISugTransferAnimator iSugTransferAnimator) {
            return null;
        }

        public static Animator $default$getSecondaryPageExitAnimator(ISugTransferAnimator iSugTransferAnimator) {
            return null;
        }
    }

    Animator getEnterAnimator();

    Animator getExitAnimator();

    Animator getSecondaryPageEnterAnimator();

    Animator getSecondaryPageExitAnimator();
}
