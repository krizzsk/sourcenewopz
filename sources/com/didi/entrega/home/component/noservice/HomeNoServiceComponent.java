package com.didi.entrega.home.component.noservice;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class HomeNoServiceComponent extends MvpComponent<HomeNoServiceView, HomeNoServicePresenter> {
    public HomeNoServiceComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public HomeNoServiceView onCreateView() {
        return new HomeNoServiceView();
    }

    /* access modifiers changed from: protected */
    public HomeNoServicePresenter onCreatePresenter() {
        return new HomeNoServicePresenter();
    }
}
