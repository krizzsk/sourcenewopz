package com.didi.soda.business.component.notice;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class BusinessDynamicNoticeComponent extends MvpComponent<BusinessDynamicNoticeView, BusinessDynamicNoticePresenter> {
    public BusinessDynamicNoticeComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public BusinessDynamicNoticeView onCreateView() {
        return new BusinessDynamicNoticeView();
    }

    /* access modifiers changed from: protected */
    public BusinessDynamicNoticePresenter onCreatePresenter() {
        return new BusinessDynamicNoticePresenter();
    }
}
