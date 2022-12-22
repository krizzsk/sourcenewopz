package com.didi.safety.god.p144ui;

import android.animation.ObjectAnimator;
import android.widget.ImageView;

/* renamed from: com.didi.safety.god.ui.ScannerDividerAnimator */
public class ScannerDividerAnimator {

    /* renamed from: a */
    private ImageView f34801a;

    /* renamed from: b */
    private ImageView f34802b;

    public ScannerDividerAnimator(ImageView imageView, ImageView imageView2) {
        this.f34801a = imageView;
        this.f34802b = imageView2;
    }

    public void startAnim() {
        this.f34801a.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f34801a, "translationY", new float[]{0.0f, (float) ((this.f34802b.getHeight() * 2) / 3)}).setDuration(3000);
        duration.setRepeatCount(-1);
        duration.start();
    }

    public void stopAnim() {
        this.f34801a.clearAnimation();
        this.f34801a.setVisibility(8);
    }
}
