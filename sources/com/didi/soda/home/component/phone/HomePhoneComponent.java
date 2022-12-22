package com.didi.soda.home.component.phone;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class HomePhoneComponent extends MvpComponent<HomePhoneView, HomePhonePresenter> {
    public HomePhoneComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public HomePhonePresenter onCreatePresenter() {
        return new HomePhonePresenter();
    }

    /* access modifiers changed from: protected */
    public HomePhoneView onCreateView() {
        return new HomePhoneView();
    }
}
