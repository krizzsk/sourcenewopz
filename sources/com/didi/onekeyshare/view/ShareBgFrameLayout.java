package com.didi.onekeyshare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.taxis99.R;

public class ShareBgFrameLayout extends FrameLayout {

    /* renamed from: a */
    private Animation.AnimationListener f29782a;

    public ShareBgFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f29782a = animationListener;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void enterAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_bg_slide_in);
        loadAnimation.setAnimationListener(this.f29782a);
        startAnimation(loadAnimation);
    }

    public void exitAnimation(Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_bg_slide_out);
        loadAnimation.setAnimationListener(animationListener);
        startAnimation(loadAnimation);
    }
}
