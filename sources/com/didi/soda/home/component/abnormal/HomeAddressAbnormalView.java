package com.didi.soda.home.component.abnormal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.soda.home.widget.HomeNoAddressView;

public class HomeAddressAbnormalView extends IView<HomeAddressAbnormalPresenter> {

    /* renamed from: a */
    private HomeNoAddressView f42553a;

    /* renamed from: b */
    private ViewGroup f42554b;

    public void showAbnormal(boolean z) {
        if (this.f42553a == null) {
            HomeNoAddressView homeNoAddressView = new HomeNoAddressView(getContext());
            this.f42553a = homeNoAddressView;
            this.f42554b.addView(homeNoAddressView);
        }
        this.f42553a.showAbnormal(z);
    }

    public void hideAbnormal() {
        this.f42554b.removeAllViews();
        this.f42553a = null;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f42554b = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(this.f42554b);
        return this.f42554b;
    }
}
