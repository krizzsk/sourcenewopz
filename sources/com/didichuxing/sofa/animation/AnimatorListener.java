package com.didichuxing.sofa.animation;

import android.view.View;

public interface AnimatorListener {
    void onAnimationEnd(Animator animator, View view);

    void onAnimationStart(Animator animator, View view);
}
