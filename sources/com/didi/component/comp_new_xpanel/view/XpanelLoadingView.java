package com.didi.component.comp_new_xpanel.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.taxis99.R;

public class XpanelLoadingView {

    /* renamed from: a */
    private View f12343a;

    /* renamed from: b */
    private LottieAnimationView f12344b = ((LottieAnimationView) this.f12343a.findViewById(R.id.animation_expect_loading_view));

    /* renamed from: c */
    private TextView f12345c;

    /* renamed from: d */
    private LottieAnimationView f12346d = ((LottieAnimationView) this.f12343a.findViewById(R.id.animation_default_loading_view1));

    /* renamed from: e */
    private LottieAnimationView f12347e = ((LottieAnimationView) this.f12343a.findViewById(R.id.animation_default_loading_view2));

    public XpanelLoadingView(Context context) {
        View inflate = View.inflate(context, R.layout.g_xp_loading, (ViewGroup) null);
        this.f12343a = inflate;
        this.f12345c = (TextView) inflate.findViewById(R.id.title_text);
    }

    public View getView() {
        return this.f12343a;
    }

    public void showDefaultLoading() {
        this.f12343a.setVisibility(0);
        this.f12345c.setVisibility(8);
        this.f12344b.setVisibility(8);
        this.f12346d.setVisibility(0);
        this.f12347e.setVisibility(0);
        this.f12346d.setRepeatCount(-1);
        this.f12346d.playAnimation();
        this.f12347e.setRepeatCount(-1);
        this.f12347e.playAnimation();
    }

    public void showExpectLoading() {
        this.f12343a.setVisibility(0);
        this.f12345c.setVisibility(0);
        this.f12344b.setVisibility(0);
        this.f12346d.setVisibility(8);
        this.f12347e.setVisibility(8);
        this.f12344b.setRepeatCount(-1);
        this.f12344b.playAnimation();
    }

    public void hideLoading() {
        this.f12344b.cancelAnimation();
        this.f12346d.cancelAnimation();
        this.f12347e.cancelAnimation();
    }
}
