package com.didi.addressold.view.tips;

import android.animation.Animator;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

class TipsWithLine$3 implements Animator.AnimatorListener {
    final /* synthetic */ C3538c this$0;
    final /* synthetic */ TipsLineView val$tipsLineView;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    TipsWithLine$3(C3538c cVar, TipsLineView tipsLineView) {
        this.this$0 = cVar;
        this.val$tipsLineView = tipsLineView;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.this$0.f8030l) {
            this.this$0.f8019a.setmRemoveListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipsWithLine$3.this.val$tipsLineView.startEndAnim(200);
                }
            });
            this.this$0.m5210f();
            boolean unused = this.this$0.f8032n = false;
        }
    }
}
