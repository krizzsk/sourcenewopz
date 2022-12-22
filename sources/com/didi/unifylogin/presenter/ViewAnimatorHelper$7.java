package com.didi.unifylogin.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ViewAnimatorHelper$7 extends AnimatorListenerAdapter {
    final /* synthetic */ C14638a this$0;

    ViewAnimatorHelper$7(C14638a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.f44847b.setVisibility(0);
        this.this$0.f44851f.setText(this.this$0.f44861p.getText());
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.f44846a.setVisibility(8);
    }
}
