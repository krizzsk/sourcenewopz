package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

class RFIndicatorViewController$1 extends AnimatorListenerAdapter {
    final /* synthetic */ C11579c this$0;
    final /* synthetic */ int val$captionToHide;
    final /* synthetic */ int val$captionToShow;
    final /* synthetic */ TextView val$captionViewToHide;
    final /* synthetic */ TextView val$captionViewToShow;

    RFIndicatorViewController$1(C11579c cVar, int i, TextView textView, int i2, TextView textView2) {
        this.this$0 = cVar;
        this.val$captionToShow = i;
        this.val$captionViewToHide = textView;
        this.val$captionToHide = i2;
        this.val$captionViewToShow = textView2;
    }

    public void onAnimationEnd(Animator animator) {
        int unused = this.this$0.f33906p = this.val$captionToShow;
        Animator unused2 = this.this$0.f33904n = null;
        TextView textView = this.val$captionViewToHide;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.val$captionToHide == 1 && this.this$0.f33910t != null) {
                this.this$0.f33910t.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.val$captionViewToShow;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            this.val$captionViewToShow.setAlpha(1.0f);
        }
    }

    public void onAnimationStart(Animator animator) {
        TextView textView = this.val$captionViewToShow;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
