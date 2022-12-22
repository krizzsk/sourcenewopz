package com.didi.soda.business.component.detail;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class BusinessDetailComponent extends MvpComponent<BusinessDetailView, BusinessDetailPresenter> {
    public BusinessDetailComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public BusinessDetailView onCreateView() {
        return new BusinessDetailView();
    }

    /* access modifiers changed from: protected */
    public BusinessDetailPresenter onCreatePresenter() {
        return new BusinessDetailPresenter();
    }
}
