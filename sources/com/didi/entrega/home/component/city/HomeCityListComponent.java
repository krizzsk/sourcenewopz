package com.didi.entrega.home.component.city;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class HomeCityListComponent extends MvpComponent<HomeCityListView, HomeCityListPresenter> {
    public HomeCityListComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public HomeCityListView onCreateView() {
        return new HomeCityListView();
    }

    /* access modifiers changed from: protected */
    public HomeCityListPresenter onCreatePresenter() {
        return new HomeCityListPresenter();
    }
}
