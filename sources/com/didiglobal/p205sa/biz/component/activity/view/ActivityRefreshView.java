package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.IHeaderView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.OnAnimEndListener;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityRefreshView */
public class ActivityRefreshView extends FrameLayout implements IHeaderView {

    /* renamed from: a */
    private static final String f50777a = "ActivityRefreshView";

    /* renamed from: b */
    private LottieAnimationView f50778b;

    /* renamed from: c */
    private boolean f50779c;

    public View getView() {
        return this;
    }

    public void onPullReleasing(float f, float f2, float f3) {
    }

    public void reset() {
    }

    public void startAnim(float f, float f2) {
    }

    public ActivityRefreshView(Context context) {
        super(context);
        m36466a();
    }

    /* renamed from: a */
    private void m36466a() {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_head_refresh, this, true);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);
        this.f50778b = lottieAnimationView;
        lottieAnimationView.setRepeatCount(-1);
        this.f50779c = false;
    }

    public void onPullingDown(float f, float f2, float f3) {
        if (!this.f50779c && f > 1.0f) {
            this.f50779c = true;
            this.f50778b.playAnimation();
        }
    }

    public void onFinish(OnAnimEndListener onAnimEndListener) {
        this.f50779c = false;
        this.f50778b.setProgress(0.0f);
        this.f50778b.cancelAnimation();
        onAnimEndListener.onAnimEnd();
    }
}
