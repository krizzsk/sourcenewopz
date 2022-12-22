package com.didi.soda.home.component.titlebar;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.home.component.titlebar.Contract;

public class HomeTitleBarComponent extends MvpComponent<Contract.AbsTitleBarView, Contract.AbsTitleBarPresenter> {
    public HomeTitleBarComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsTitleBarView onCreateView() {
        return new HomeTitleBarView();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsTitleBarPresenter onCreatePresenter() {
        return new HomeTitleBarPresenter();
    }
}
