package com.didi.unifylogin.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import com.didi.unifylogin.utils.KeyboardHelper;

class ViewAnimatorHelper$4 extends AnimatorListenerAdapter {
    final /* synthetic */ C14638a this$0;

    ViewAnimatorHelper$4(C14638a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.this$0.f44846a.setVisibility(0);
        this.this$0.f44846a.setLeftVisible(true);
        if (TextUtils.isEmpty(this.this$0.f44861p.getText())) {
            this.this$0.f44863r.setVisibility(8);
        } else {
            this.this$0.f44863r.setVisibility(0);
        }
        this.this$0.f44849d.setVisibility(0);
        this.this$0.f44849d.setBackgroundColor(0);
        this.this$0.f44857l.setAlpha(0.0f);
        this.this$0.f44860o.setAlpha(0.0f);
        this.this$0.f44863r.setAlpha(0.0f);
        this.this$0.f44858m.setAlpha(0.0f);
        this.this$0.f44859n.setAlpha(0.0f);
        this.this$0.f44862q.setAlpha(0.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.f44861p.requestFocus();
        this.this$0.f44847b.setVisibility(8);
        KeyboardHelper.showInputMethod(this.this$0.f44861p.getContext(), this.this$0.f44861p);
    }
}
