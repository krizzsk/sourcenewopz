package com.iproov.sdk.p223ui.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

/* renamed from: com.iproov.sdk.ui.views.ProgressView */
public class ProgressView extends ProgressBar {

    /* renamed from: a */
    private final ObjectAnimator f54442a = ObjectAnimator.ofInt(this, "progress", new int[]{0});

    public ProgressView(Context context) {
        super(context);
        m39377a();
    }

    /* renamed from: a */
    private void m39377a() {
        this.f54442a.setAutoCancel(true);
        this.f54442a.setInterpolator(new LinearInterpolator());
    }

    /* renamed from: do */
    public void mo162212do(int i, long j) {
        this.f54442a.setIntValues(new int[]{i});
        this.f54442a.setDuration(j);
        this.f54442a.start();
    }

    /* renamed from: do */
    public void mo162211do() {
        this.f54442a.cancel();
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39377a();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39377a();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m39377a();
    }
}
