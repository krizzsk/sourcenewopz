package com.didi.entrega.home.component.abnormal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.mvp.IView;

public class HomeAddressAbnormalView extends IView<HomeAddressAbnormalPresenter> {

    /* renamed from: a */
    private HomeNoAddressView f20637a;

    /* renamed from: b */
    private ViewGroup f20638b;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f20638b = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(this.f20638b);
        return this.f20638b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61646a() {
        if (this.f20637a == null) {
            HomeNoAddressView homeNoAddressView = new HomeNoAddressView(getContext());
            this.f20637a = homeNoAddressView;
            this.f20638b.addView(homeNoAddressView);
        }
        this.f20637a.showAbnormal();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo61647b() {
        this.f20638b.removeAllViews();
        this.f20637a = null;
    }
}
