package com.didi.component.base;

import android.animation.Animator;
import android.view.View;
import android.view.ViewTreeObserver;

class BaseFragment$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C4539a this$0;

    BaseFragment$1(C4539a aVar) {
        this.this$0 = aVar;
    }

    public void onGlobalLayout() {
        View a = this.this$0.f10995f;
        if (a != null) {
            a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            Animator m = this.this$0.mo45682m();
            if (m != null) {
                m.start();
            }
            this.this$0.mo45681l();
        }
    }
}
