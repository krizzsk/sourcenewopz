package com.didichuxing.security.cardverify.globalpay.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GlobalPayLottieLoadingView extends LottieAnimationView {

    /* renamed from: a */
    Runnable f48927a = new Runnable() {
        public void run() {
            GlobalPayLottieLoadingView.this.removeCallbacks(this);
            GlobalPayLottieLoadingView.this.playAnimation();
        }
    };

    public GlobalPayLottieLoadingView(Context context) {
        super(context);
    }

    public GlobalPayLottieLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GlobalPayLottieLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void show() {
        start();
        setVisibility(0);
    }

    public void hide() {
        stop();
        setVisibility(8);
    }

    public boolean isRunning() {
        return getVisibility() == 0 && isAnimating();
    }

    public void start() {
        removeCallbacks(this.f48927a);
        if (isShown()) {
            playAnimation();
        } else {
            post(this.f48927a);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f48927a);
        super.onDetachedFromWindow();
    }

    public void pauseAnimation() {
        super.pauseAnimation();
        removeCallbacks(this.f48927a);
    }

    public void cancelAnimation() {
        super.cancelAnimation();
        removeCallbacks(this.f48927a);
    }

    public void stop() {
        cancelAnimation();
    }

    public void setLoadingRes(int i) {
        if (isRunning()) {
            stop();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(i)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    setAnimationFromJson(sb.toString(), (String) null);
                    return;
                }
            }
        } catch (Resources.NotFoundException | IOException unused) {
        }
    }
}
