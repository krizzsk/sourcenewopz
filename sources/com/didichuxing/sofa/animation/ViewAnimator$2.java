package com.didichuxing.sofa.animation;

import com.didichuxing.sofa.animation.Animator;

class ViewAnimator$2 implements Animator.PrepareAnimationCallback {
    final /* synthetic */ C16476w this$0;

    ViewAnimator$2(C16476w wVar) {
        this.this$0 = wVar;
    }

    public void onPrepared() {
        this.this$0.m35410d();
        boolean unused = this.this$0.f49142g = true;
        C16476w wVar = this.this$0;
        wVar.m35404a("build onPrepared mPending: " + this.this$0.f49143h);
        if (this.this$0.f49143h) {
            boolean unused2 = this.this$0.f49143h = false;
            this.this$0.m35412e();
        }
    }
}
