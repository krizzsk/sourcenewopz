package com.didi.onekeyshare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.taxis99.R;

public class ShareBottomLinearLayout extends LinearLayout {
    public ShareBottomLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            enterAnimation();
        }
    }

    public void enterAnimation() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_footer_slide_in));
    }

    public void exitAnimation(Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.tone_share_footer_slide_out);
        loadAnimation.setAnimationListener(animationListener);
        startAnimation(loadAnimation);
    }
}
