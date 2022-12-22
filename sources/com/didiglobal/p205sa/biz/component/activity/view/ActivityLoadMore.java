package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.IBottomView;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityLoadMore */
public class ActivityLoadMore extends FrameLayout implements IBottomView {

    /* renamed from: a */
    private static final String f50756a = "ActivityLoadMore";

    /* renamed from: b */
    private LottieAnimationView f50757b;

    /* renamed from: c */
    private boolean f50758c;

    /* renamed from: d */
    private View f50759d;

    public View getView() {
        return this;
    }

    public void onPullReleasing(float f, float f2, float f3) {
    }

    public void reset() {
    }

    public void startAnim(float f, float f2) {
    }

    public ActivityLoadMore(Context context) {
        super(context);
        m36453a();
    }

    /* renamed from: a */
    private void m36453a() {
        this.f50759d = LayoutInflater.from(getContext()).inflate(R.layout.activity_bottom_load, this, true);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        this.f50757b = lottieAnimationView;
        lottieAnimationView.setRepeatCount(-1);
        this.f50758c = false;
    }

    public void onPullingUp(float f, float f2, float f3) {
        if (!this.f50758c && f < -1.0f) {
            this.f50758c = true;
            this.f50757b.playAnimation();
        }
    }

    public void onFinish() {
        this.f50758c = false;
        this.f50757b.setProgress(0.0f);
        this.f50757b.cancelAnimation();
    }
}
