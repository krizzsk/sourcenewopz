package com.didi.rfusion.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

public class RFLottieLoadingView extends LottieAnimationView {
    public RFLottieLoadingView(Context context) {
        super(context);
    }

    public RFLottieLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RFLottieLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void show() {
        if (!isRunning()) {
            start();
            setVisibility(0);
        }
    }

    public void hide() {
        if (isRunning()) {
            stop();
            setVisibility(8);
        }
    }

    public boolean isRunning() {
        return getVisibility() == 0 && isAnimating();
    }

    public void start() {
        playAnimation();
    }

    public void stop() {
        cancelAnimation();
    }
}
