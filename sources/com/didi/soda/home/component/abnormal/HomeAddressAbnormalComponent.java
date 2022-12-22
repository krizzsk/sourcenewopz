package com.didi.soda.home.component.abnormal;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class HomeAddressAbnormalComponent extends MvpComponent<HomeAddressAbnormalView, HomeAddressAbnormalPresenter> {
    public HomeAddressAbnormalComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public HomeAddressAbnormalView onCreateView() {
        return new HomeAddressAbnormalView();
    }

    /* access modifiers changed from: protected */
    public HomeAddressAbnormalPresenter onCreatePresenter() {
        return new HomeAddressAbnormalPresenter();
    }
}
